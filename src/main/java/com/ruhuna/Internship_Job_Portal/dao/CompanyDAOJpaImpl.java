package com.ruhuna.Internship_Job_Portal.dao;

import com.ruhuna.Internship_Job_Portal.model.Company;
import com.ruhuna.Internship_Job_Portal.model.JobPost;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyDAOJpaImpl implements CompanyDAO{

    private EntityManager entityManager;
    @Autowired
    public CompanyDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Company findById(int id) {
        Company company = entityManager.find(Company.class, id);
        return company;
    }

    @Override
    public Company findByEmail(String email, String password) throws Exception {
        String query = "SELECT u FROM Company u WHERE u.companyEmail = :email";
        Company company = entityManager.createQuery(query, Company.class)
                .setParameter("email", email)
                .getSingleResult();

        if (company == null || !company.getPassword().equals(password)) {
            throw new Exception("Invalid email or password");
        }

        return company;
    }


    @Override
    public void saveCompany(Company company) {
        Company companySaved = entityManager.merge(company);
    }

    @Override
    public List<Company> findAllCompany() {
        TypedQuery<Company> allCompanyQuery = entityManager.createQuery("from Company", Company.class);

        return allCompanyQuery.getResultList();
    }
}
