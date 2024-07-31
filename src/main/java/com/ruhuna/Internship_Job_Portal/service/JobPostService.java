package com.ruhuna.Internship_Job_Portal.service;

import com.ruhuna.Internship_Job_Portal.dao.LoginRequest;
import com.ruhuna.Internship_Job_Portal.model.JobPost;

import java.util.List;

public interface JobPostService {
    List<JobPost> findAllJobPosts();
    void addJobPost(JobPost jobPost);

    void deleteJobPost(int id);

    List<JobPost> findCompanyJobPosts(String email);
}
