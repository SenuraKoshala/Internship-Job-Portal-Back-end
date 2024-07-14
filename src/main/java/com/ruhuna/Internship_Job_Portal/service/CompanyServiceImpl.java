package com.ruhuna.Internship_Job_Portal.service;

import com.ruhuna.Internship_Job_Portal.dao.CompanyDAOJpaImpl;
import com.ruhuna.Internship_Job_Portal.dao.LoginRequest;
import com.ruhuna.Internship_Job_Portal.model.Company;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CompanyServiceImpl implements CompanyService{

    private CompanyDAOJpaImpl companyDAOJpa;
    @Autowired
    public CompanyServiceImpl(CompanyDAOJpaImpl companyDAOJpa) {
        this.companyDAOJpa = companyDAOJpa;
    }

    @Override
    public Company findCompanyById(int id) {
        return companyDAOJpa.findById(id);
    }

    @Override
    @Transactional
    public void companySignUp(Company company) {
        companyDAOJpa.saveCompany(company);
    }

    @Override
    public Company companyLogin(String email) {

        List<Company> companies = companyDAOJpa.findAllCompany();


        for(Company item : companies){
            if(item.getCompanyEmail() == email){
                return item;
            }
            else {
                return null;
            }
        }
        return null;
    }

    @Override
    public Company findByEmail(String email, String password) throws Exception {
        return companyDAOJpa.findByEmail(email, password);
    }

    @Override
    public List<Company> findAllCompanies() {
        return companyDAOJpa.findAllCompany();
    }
}
