package com.example.HireVis.scraper;

import com.example.HireVis.entity.JobPosting;

import java.util.List;

public interface Scraper {
    public List<JobPosting> getJobPostings(String keywords,String location);
}