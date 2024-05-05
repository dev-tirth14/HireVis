package com.example.HireVis.service;

import com.example.HireVis.dto.ChatGPTRequestDTO;
import com.example.HireVis.dto.ChatGPTResponseDTO;
import com.example.HireVis.model.JobPosting;
import com.example.HireVis.model.Ranking;
import com.example.HireVis.model.Resume;
import com.example.HireVis.repository.RankingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RankingService {
    @Value("${openai.model}")
    private String model;
    @Value("${openai.api.url}")
    private String apiURL;


    @Autowired
    private RestTemplate template;

    @Autowired
    private RankingRepo rankingRepo;

    public RankingService(){}

    public List<JobPosting> rankJobsBasedOnResume(Resume resume, List<JobPosting> jobPostings){
        String prompt= "Resume: "+resume.toString()+" Jobs: "+jobPostings.toString()+" Rank the given job postings based on relevance with my resume details and give me the jobIDs in order of relevance. Make sure you include all the jobs. Only include the rankings and no other extra information. Each line should match the pattern: id: <JobID>";
        ChatGPTRequestDTO request=new ChatGPTRequestDTO(model,prompt);
        ChatGPTResponseDTO responseDTO=template.postForObject(apiURL,request, ChatGPTResponseDTO.class);
        String content=responseDTO.getChoices().get(0).getMessage().getContent();
        System.out.println("RESPONSE: ");
        System.out.println(content);
        System.out.println("------------------------------");
        List<JobPosting> orderedJobs=parseRankingResponse(content,jobPostings);
        saveRanking(orderedJobs);
        return orderedJobs;
    }

    private List<JobPosting> parseRankingResponse(String response, List<JobPosting> jobPostings){
        List<String> jobIDs=new ArrayList<>();
        String regex = "id: \\d{10}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(response);

        while (matcher.find()) {
            jobIDs.add(matcher.group());
        }

        List<String> cleanedJobIds=jobIDs.stream().map(id-> id.replace("id: ","")).toList();

        List<JobPosting> rankedJobs=jobPostings.stream()
                .filter(jobPosting -> cleanedJobIds.contains(jobPosting.getId()))
                .sorted(Comparator.comparingInt(jobPosting -> cleanedJobIds.indexOf(jobPosting.getId())))
                .toList();
        return rankedJobs;
    }

    private void saveRanking(List<JobPosting> jobPostings){
        rankingRepo.deleteAll();
        jobPostings.forEach(job->rankingRepo.save(new Ranking(job)));
    }
    public List<JobPosting> getAllRankedJobs(){
        List<Ranking> rankings=rankingRepo.findAll();
        return rankings.stream().map(ranking -> ranking.getJobPosting()).toList();
    }

}
