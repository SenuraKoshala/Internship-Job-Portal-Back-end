package com.ruhuna.Internship_Job_Portal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Company {
    @Id
    private int companyId;
    private String companyName;
    private String companyType;
    private String companyEmail;
    private String password;

    public Company() {
    }

    public Company(String companyName, String companyType, String companyEmail, String password) {
        this.companyName = companyName;
        this.companyType = companyType;
        this.companyEmail = companyEmail;
        this.password = password;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
