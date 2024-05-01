package com.example.HireVis.model;

import jakarta.persistence.*;

@Entity
@Table(name = "job_posting")
public class JobPosting {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "url")
    private String url;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "description")
    private String description;
    public JobPosting(){}
    public JobPosting(String id, String url, String roleName, String companyName, String description) {
        this.id = id;
        this.url = url;
        this.roleName = roleName;
        this.companyName = companyName;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "JobPosting{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", roleName='" + roleName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
