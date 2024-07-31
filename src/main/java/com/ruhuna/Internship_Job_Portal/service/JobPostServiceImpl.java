package com.ruhuna.Internship_Job_Portal.service;

import com.ruhuna.Internship_Job_Portal.dao.JobPostDAOJpaImpl;
import com.ruhuna.Internship_Job_Portal.dao.LoginRequest;
import com.ruhuna.Internship_Job_Portal.model.JobPost;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class JobPostServiceImpl implements JobPostService{

    private JobPostDAOJpaImpl jobPostDAOJpa;
    @Autowired
    public JobPostServiceImpl(JobPostDAOJpaImpl jobPostDAOJpa) {
        this.jobPostDAOJpa = jobPostDAOJpa;
    }

    @Override
    public List<JobPost> findAllJobPosts() {
        return jobPostDAOJpa.findAllJobPosts();
    }

    @Override
    @Transactional
    public void addJobPost(JobPost jobPost) {
        jobPostDAOJpa.saveJobPost(jobPost);
    }

    @Override
    public void deleteJobPost(int id) {
        jobPostDAOJpa.deleteJobPost(id);
    }

    @Override
    public List<JobPost> findCompanyJobPosts(String email) {

        return jobPostDAOJpa.findJobPostsInParticularCompany(email);
    }


}
