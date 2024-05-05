package com.example.HireVis.service;

import com.example.HireVis.dto.JobPostingDTO;
import com.example.HireVis.model.JobPosting;
import com.example.HireVis.repository.JobPostingRepo;
import com.example.HireVis.scraper.LinkedInScraper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JobPostingService {
    private JobPostingRepo jobPostingRepo;
    private LinkedInScraper scraper;

    @Autowired
    public JobPostingService(JobPostingRepo jobPostingRepo, LinkedInScraper scraper){
        this.jobPostingRepo=jobPostingRepo;
        this.scraper=scraper;
    }

    public JobPosting createJobPosting(JobPostingDTO jobPostingDTO){
        JobPosting jobPosting=mapToJobPosting(jobPostingDTO);
        System.out.println(jobPosting.getUrl().length()+" --> "+jobPosting.getUrl());
        jobPostingRepo.save(jobPosting);
        return jobPosting;
    }

    public JobPosting getJobPosting(String jobId){
       Optional<JobPosting> jobPosting=jobPostingRepo.findById(jobId);
       return jobPosting.isEmpty()?null:jobPosting.get();
    }
    public List<JobPosting> getAllJobPosting(){
        List<JobPosting> jobPostings=jobPostingRepo.findAll();
        return jobPostings;
    }

    public List<JobPosting> scrapeJobs(String keywords, String location){
        jobPostingRepo.deleteAll();
        List<JobPostingDTO> jobPostingDTOs=scraper.getJobPostings(keywords,location);
        if(jobPostingDTOs==null){
            return null;
        }
        List<JobPosting> jobPostings=jobPostingDTOs.stream().map(jobPostingDTO -> {
            return createJobPosting(jobPostingDTO);
        }).toList();
        return jobPostings;
    }

    private JobPosting mapToJobPosting(JobPostingDTO jobPostingDTO){
        return new JobPosting(
                jobPostingDTO.getId(),
                jobPostingDTO.getUrl(),
                jobPostingDTO.getRoleName(),
                jobPostingDTO.getCompanyName(),
                jobPostingDTO.getDescription()
                );
    }

}
