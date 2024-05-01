package com.example.HireVis.service;

import com.example.HireVis.dto.JobPostingDTO;
import com.example.HireVis.model.JobPosting;
import com.example.HireVis.repository.JobPostingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JobPostingService {
    private JobPostingRepo jobPostingRepo;

    @Autowired
    public JobPostingService(JobPostingRepo jobPostingRepo){
        this.jobPostingRepo=jobPostingRepo;
    }

    public JobPosting createJobPosting(JobPostingDTO jobPostingDTO){
        JobPosting jobPosting=mapToJobPosting(jobPostingDTO);
        jobPostingRepo.save(jobPosting);
        return jobPosting;
    }

    public JobPosting getJobPosting(String jobId){
       Optional<JobPosting> jobPosting=jobPostingRepo.findById(jobId);
       return jobPosting.isEmpty()?null:jobPosting.get();
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
