package com.example.HireVis.dto;

import java.util.Date;
import java.util.List;

public class ResumeDTO {
    private Date created_date;
    private int user_id;
    private List<SkillDTO> skills;
    private List<ProjectDTO> projects;
    private List<WorkExperienceDTO> experiences;
    private List<EducationDTO> education;

    public ResumeDTO(){}

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public List<SkillDTO> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillDTO> skills) {
        this.skills = skills;
    }

    public List<ProjectDTO> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectDTO> projects) {
        this.projects = projects;
    }

    public List<WorkExperienceDTO> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<WorkExperienceDTO> experiences) {
        this.experiences = experiences;
    }

    public List<EducationDTO> getEducation() {
        return education;
    }

    public void setEducation(List<EducationDTO> education) {
        this.education = education;
    }
}
