package com.example.HireVis.scraper;

import com.example.HireVis.entity.JobPosting;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LinkedInScraper implements Scraper{
    private String url;

    public LinkedInScraper(String url) {
        this.url = url;
    }

    @Override
    public List<JobPosting> getJobPostings(String keywords,String location) {
        if(keywords==null || location==null){
            return null;
        }
        List<JobPosting> jobPostings=new ArrayList<>();
        String specifiedURL=url
                .replace("{KEYWORDS}",String.join("%20",keywords.split(" ")))
                .replace("{LOCATION}",String.join("%20",location.split(" ")));
        System.out.println(specifiedURL);
        try{
            Document doc= Jsoup.connect(specifiedURL).get();
            Elements jobPostingCards=doc.select(".job-search-card");
            for(Element element:jobPostingCards){
                String jobName=element.select(".base-search-card__title").text();
                System.out.println(jobName);
            }
        }catch(IOException e){
            e.printStackTrace();

        }
        return jobPostings;
    }
}
