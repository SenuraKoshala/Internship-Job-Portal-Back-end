package com.ruhuna.Internship_Job_Portal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class JobPost {
    @Id
    private int jobPostId;
    private String companyName;
    private String roleName;
    private String jobDescreption;
    private String contactInfo;
    private int internPeriod;
    private int impressions;

    public JobPost() {
    }

    public JobPost(String companyName, String roleName, String jobDescreption, String contactInfo, int internPeriod, int impressions) {
        this.companyName = companyName;
        this.roleName = roleName;
        this.jobDescreption = jobDescreption;
        this.contactInfo = contactInfo;
        this.internPeriod = internPeriod;
        this.impressions = impressions;
    }

    public int getJobPostId() {
        return jobPostId;
    }

    public void setJobPostId(int jobPostId) {
        this.jobPostId = jobPostId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getJobDescreption() {
        return jobDescreption;
    }

    public void setJobDescreption(String jobDescreption) {
        this.jobDescreption = jobDescreption;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public int getInternPeriod() {
        return internPeriod;
    }

    public void setInternPeriod(int internPeriod) {
        this.internPeriod = internPeriod;
    }

    public int getImpressions() {
        return impressions;
    }

    public void setImpressions(int impressions) {
        this.impressions = impressions;
    }
}
