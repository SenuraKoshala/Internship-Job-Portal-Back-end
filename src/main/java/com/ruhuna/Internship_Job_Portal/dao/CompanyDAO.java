package com.ruhuna.Internship_Job_Portal.dao;

import com.ruhuna.Internship_Job_Portal.model.Company;

import java.util.List;

public interface CompanyDAO {
    Company findById(int id);

    public Company findByEmail(String email, String password) throws Exception;
    void saveCompany(Company company);

    List<Company> findAllCompany();
}
