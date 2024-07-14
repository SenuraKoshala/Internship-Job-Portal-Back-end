package com.ruhuna.Internship_Job_Portal.service;

import com.ruhuna.Internship_Job_Portal.dao.LoginRequest;
import com.ruhuna.Internship_Job_Portal.model.Company;

import java.util.List;

public interface CompanyService {
    Company findCompanyById(int id);
    void companySignUp(Company company);

    Company companyLogin(String email);
    Company findByEmail(String email, String password) throws Exception;

    List<Company> findAllCompanies();
}
