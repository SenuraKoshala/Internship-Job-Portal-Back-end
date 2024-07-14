package com.ruhuna.Internship_Job_Portal.rest;

import com.ruhuna.Internship_Job_Portal.model.JobPost;
import com.ruhuna.Internship_Job_Portal.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
public class JobPostRestController {

    private JobPostService jobPostService;
    @Autowired
    public JobPostRestController(JobPostService jobPostService) {
        this.jobPostService = jobPostService;
    }

    @GetMapping("/api/jobposts")
    public ResponseEntity<List<JobPost>> getAllJobPosts(){
        List<JobPost> jobPostList = jobPostService.findAllJobPosts();
        return new ResponseEntity<>(jobPostList, HttpStatus.OK);
    }

    @PostMapping("api/jobposts")
    public void addJobPost(@RequestBody JobPost jobPost){
        jobPostService.addJobPost(jobPost);
    }
    @PutMapping("api/jobposts")
    public void updateJobPost(@RequestBody JobPost jobPost){
        jobPostService.addJobPost(jobPost);
    }

    @DeleteMapping("/api/jobposts")
    public void deleteJobPost(@PathVariable int id){
        jobPostService.deleteJobPost(id);
    }

}
