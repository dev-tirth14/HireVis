package com.example.HireVis.dto;

public class JobPostingDTO {
    private String id;
    private String roleName;
    private String companyName;
    private String description;
    private String url;
    public JobPostingDTO(){}

    public JobPostingDTO(String id,String url, String roleName, String companyName, String description) {
        this.id = id;
        this.url=url;
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
        return "JobPostingDTO{" +
                "id='" + id + '\'' +
                ", roleName='" + roleName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
