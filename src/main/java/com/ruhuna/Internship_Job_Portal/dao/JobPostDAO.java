package com.ruhuna.Internship_Job_Portal.dao;

import com.ruhuna.Internship_Job_Portal.model.JobPost;

import java.util.List;

public interface JobPostDAO {
    List<JobPost> findAllJobPosts();
    void saveJobPost(JobPost jobPost);

    JobPost findById(int id);
    void deleteJobPost(int id);

    void updateImpression(int id);

    List<JobPost> findJobPostsInParticularCompany(String email);


}
