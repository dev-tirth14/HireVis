package com.example.HireVis.dto;

public class ScrapeSearchDTO {
    private String keywords;
    private String location;
    public ScrapeSearchDTO(){}

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
