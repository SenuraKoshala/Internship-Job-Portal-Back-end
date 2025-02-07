package com.ruhuna.Internship_Job_Portal.dao;

import com.ruhuna.Internship_Job_Portal.model.JobPost;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class JobPostDAOJpaImpl implements JobPostDAO{

    private EntityManager entityManager;
    @Autowired
    public JobPostDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<JobPost> findAllJobPosts() {
        TypedQuery<JobPost> allJobPostQuery = entityManager.createQuery("from JobPost", JobPost.class);
        List<JobPost> allJobPosts = allJobPostQuery.getResultList();

        return allJobPosts;
    }

    @Override
    public void saveJobPost(JobPost jobPost) {
        JobPost savedJopPost = entityManager.merge(jobPost);
    }

    @Override
    public JobPost findById(int id) {
        JobPost jobPost = entityManager.find(JobPost.class, id);
        return jobPost;
    }

    @Override
    public void deleteJobPost(int id) {
        JobPost jobPost = entityManager.find(JobPost.class, id);
        entityManager.remove(id);
    }

    @Override
    public void updateImpression(int id) {
        JobPost jobPost = entityManager.find(JobPost.class, id);

        if (jobPost != null) {
            int updatedImpressions = jobPost.getImpressions() + 1;
            jobPost.setImpressions(updatedImpressions);

            entityManager.merge(jobPost);
        }
    }

    @Override
    public List<JobPost> findJobPostsInParticularCompany(String email) {
        String jpql = "SELECT jp FROM JobPost jp WHERE jp.contactInfo = :email";
        TypedQuery<JobPost> query = entityManager.createQuery(jpql, JobPost.class);
        query.setParameter("email", email);
        return query.getResultList();
    }
}
