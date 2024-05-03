package com.example.HireVis.scraper;

import com.example.HireVis.dto.JobPostingDTO;

import java.util.List;

public interface Scraper {
    public List<JobPostingDTO> getJobPostings(String keywords, String location);
}