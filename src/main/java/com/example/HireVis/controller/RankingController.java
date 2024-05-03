package com.example.HireVis.controller;

import com.example.HireVis.model.JobPosting;
import com.example.HireVis.model.Resume;
import com.example.HireVis.service.JobPostingService;
import com.example.HireVis.service.RankingService;
import com.example.HireVis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RankingController {
    private UserService userService;
    private JobPostingService jobPostingService;
    private RankingService rankingService;

    @Autowired
    public RankingController(UserService userService, JobPostingService jobPostingService, RankingService rankingService){
        this.userService=userService;
        this.jobPostingService=jobPostingService;
        this.rankingService=rankingService;
    }

    @GetMapping("/getRankings")
    public String getRankings() {
        // Process the DTO
        Resume resume=userService.getResume(1);
        List<JobPosting> jobPostings=jobPostingService.getAllJobPosting();
        return rankingService.rankJobsBasedOnResume(resume,jobPostings);
    }
}
