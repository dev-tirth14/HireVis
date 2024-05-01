package com.example.HireVis.controller;

import com.example.HireVis.dto.JobPostingDTO;
import com.example.HireVis.model.JobPosting;
import com.example.HireVis.service.JobPostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class JobPostingController {
    private JobPostingService jobPostingService;

    @Autowired
    public JobPostingController(JobPostingService jobPostingService){
        this.jobPostingService=jobPostingService;
    }

    @PostMapping("/createJobPosting")
    public String createJobPosting(@RequestBody JobPostingDTO jobPostingDTO) {
        // Process the DTO
        JobPosting jobPosting=jobPostingService.createJobPosting(jobPostingDTO);
        return "Job posting has been created: "+jobPosting.toString();
    }

    @GetMapping("/jobPostings/{postingId}")
    public String getJobPosting(@PathVariable String postingId) {
        // Process the DTO
        JobPosting jobPosting=jobPostingService.getJobPosting(postingId);
        return jobPosting==null?"Job Posting "+postingId+" NOT found":jobPosting.toString();
    }

}
