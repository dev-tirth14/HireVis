package com.example.HireVis.scraper;

import com.example.HireVis.dto.JobPostingDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class LinkedInScraper implements Scraper{
    private static final String url="https://www.linkedin.com/jobs/search/?f_TPR=r86400&keywords={KEYWORDS}&location={LOCATION}&origin=JOB_SEARCH_PAGE_JOB_FILTER";

    public LinkedInScraper() {}

    @Override
    public List<JobPostingDTO> getJobPostings(String keywords, String location) {
        if(keywords==null || location==null){
            return null;
        }
        List<JobPostingDTO> jobPostings=new ArrayList<>();
        String specifiedURL=url
                .replace("{KEYWORDS}",String.join("%20",keywords.split(" ")))
                .replace("{LOCATION}",String.join("%20",location.split(" ")));
        System.out.println(specifiedURL);
        try{
            Document doc= Jsoup.connect(specifiedURL).get();
            Elements jobPostingCards=doc.select(".job-search-card");

            for(Element element:jobPostingCards.subList(0,2)){
                String jobURL=element.select(".base-card__full-link").attr("href");
                String postDate=element.select(".job-search-card__listdate--new").attr("datetime");
                String[] brokenURL=jobURL.replace("https://www.linkedin.com/jobs/view/","").split("\\?")[0].split("-");
                String jobId=brokenURL[brokenURL.length-1];
                String jobName=element.select(".base-search-card__title").text();
                String companyName=element.select(".base-search-card__subtitle").first().child(0).text();
                Document jobPostingDoc=Jsoup.connect(jobURL).get();
                String description=jobPostingDoc.select(".description__text").get(0).text();
                System.out.println("["+jobId+"] --> "+jobName +" @ "+companyName + " --> "+postDate);

                JobPostingDTO jobPosting=new JobPostingDTO(jobId,jobURL,jobName,companyName,description);
                jobPostings.add(jobPosting);
            }
        }catch(IOException e){
            e.printStackTrace();

        }
        return jobPostings;
    }
}
