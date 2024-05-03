package com.example.HireVis.service;

import com.example.HireVis.dto.ChatGPTRequestDTO;
import com.example.HireVis.dto.ChatGPTResponseDTO;
import com.example.HireVis.model.JobPosting;
import com.example.HireVis.model.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RankingService {
    @Value("${openai.model}")
    private String model;
    @Value("${openai.api.url}")
    private String apiURL;


    @Autowired
    private RestTemplate template;

    public RankingService(){}

    public String rankJobsBasedOnResume(Resume resume, List<JobPosting> jobPostings){
        String prompt= "Resume: "+resume.toString()+" Jobs: "+jobPostings.toString()+" Rank the given job postings based on relevance with my resume details and give me the jobIDs in order of relevance. Only include the rankings and no other extra information.";
        ChatGPTRequestDTO request=new ChatGPTRequestDTO(model,prompt);
        ChatGPTResponseDTO responseDTO=template.postForObject(apiURL,request, ChatGPTResponseDTO.class);
        return responseDTO.getChoices().get(0).getMessage().getContent();
    }

}
