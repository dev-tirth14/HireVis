package com.example.HireVis.controller;

import com.example.HireVis.dto.JobPostingDTO;
import com.example.HireVis.dto.ScrapeSearchDTO;
import com.example.HireVis.model.JobPosting;
import com.example.HireVis.service.JobPostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobPostingController {
    private JobPostingService jobPostingService;


    @Autowired
    public JobPostingController(JobPostingService jobPostingService){
        this.jobPostingService=jobPostingService;
    }

    @PostMapping("/jobPostings/create")
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

    @GetMapping("/jobPostings/scrape")
    public String scrapeJobPosting(@RequestBody ScrapeSearchDTO scrapeSearchDTO) {
        // Process the DTO
        List<JobPosting> jobPosting=jobPostingService.scrapeJobs(scrapeSearchDTO.getKeywords(),scrapeSearchDTO.getLocation());
        if(jobPosting==null){
            return "Something went wrong! Try again later.";
        }
        return jobPosting.toString();
    }

    @GetMapping("/jobPostings")
    public String getJobPosting() {
        // Process the DTO
        List<JobPosting> jobPosting=jobPostingService.getAllJobPosting();
        return jobPosting.toString();
    }

}
