package com.example.HireVis.controller;

import com.example.HireVis.model.JobPosting;
import com.example.HireVis.model.Resume;
import com.example.HireVis.service.JobPostingService;
import com.example.HireVis.service.RankingService;
import com.example.HireVis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/users/{userID}/rankJobs")
    public String rankJobs(@PathVariable int userID) {
        Resume resume=userService.getUser(userID).getResumes().get(0);
        List<JobPosting> jobPostings=jobPostingService.getAllJobPosting();
        List<JobPosting> rankedJobPostings=rankingService.rankJobsBasedOnResume(resume,jobPostings);

        return rankedJobPostings.stream().map(jobPosting -> jobPosting.getRoleName()+" @ "+jobPosting.getCompanyName()).toList().toString();
    }
    @GetMapping("/getRankedJobs")
    public String getRankedJobs() {
        List<JobPosting> jobPostings=rankingService.getAllRankedJobs();
        String responseString="";
        return String.join("\n",jobPostings.stream()
                .map(jobPosting -> jobPosting.getRoleName()+" @ "+jobPosting.getCompanyName()+" ---> "+jobPosting.getUrl())
                .toList());
    }


}
