package com.example.HireVis.entity;

public class JobPosting {
    private String company;
    private String jobID;
    private String roleName;
    private String details;

    public JobPosting(String company, String jobID, String roleName, String details) {
        this.company = company;
        this.jobID = jobID;
        this.roleName = roleName;
        this.details = details;
    }

    @Override
    public String toString() {
        return "JobPosting{" +
                "company='" + company + '\'' +
                ", jobID='" + jobID + '\'' +
                ", roleName='" + roleName + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
