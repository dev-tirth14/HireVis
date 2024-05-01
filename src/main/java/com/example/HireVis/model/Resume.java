package com.example.HireVis.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "resume")
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name = "created_date")
    private Date created_date;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {
            CascadeType.REFRESH,
            CascadeType.DETACH,
            CascadeType.PERSIST,
            CascadeType.MERGE,
    })
    @JoinColumn(name = "user_id")
    private UserProfile user;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {
            CascadeType.REFRESH,
            CascadeType.DETACH,
            CascadeType.PERSIST,
            CascadeType.MERGE,
    })
    @JoinTable(
            name = "resume_skill",
            joinColumns = @JoinColumn(name = "resume_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<Skill> skills;

    @OneToMany(mappedBy = "resume",fetch = FetchType.LAZY, cascade = {
            CascadeType.REFRESH,
            CascadeType.DETACH,
            CascadeType.PERSIST,
            CascadeType.MERGE,
    })
    private List<Project> projects;

    @OneToMany(mappedBy = "resume",fetch = FetchType.LAZY, cascade = {
            CascadeType.REFRESH,
            CascadeType.DETACH,
            CascadeType.PERSIST,
            CascadeType.MERGE,
    })
    private List<WorkExperience> experiences;

    @OneToMany(mappedBy = "resume",fetch = FetchType.LAZY, cascade = {
            CascadeType.REFRESH,
            CascadeType.DETACH,
            CascadeType.PERSIST,
            CascadeType.MERGE,
    })
    private List<Education> educations;

    public Resume(){}
    public Resume(Date created_date, UserProfile user, List<Skill> skills, List<Project> projects, List<WorkExperience> experiences, List<Education> educations) {
        this.created_date = created_date;
        this.user = user;
        this.skills = skills;
        this.projects = projects;
        this.experiences = experiences;
        this.educations = educations;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public UserProfile getUser() {
        return user;
    }

    public void setUser(UserProfile user) {
        this.user = user;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {

        this.projects = projects;
        for(Project project:projects){
            if(project.getResume()==null){
                project.setResume(this);
            }
        }
    }

    public List<WorkExperience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<WorkExperience> experiences) {

        this.experiences = experiences;
        for(WorkExperience experience:experiences){
            if(experience.getResume()==null){
                experience.setResume(this);
            }
        }
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
        for(Education education:educations){
            if(education.getResume()==null){
                education.setResume(this);
            }
        }
    }

    @Override
    public String toString() {
        return "Resume{" +
                "id=" + id +
                ", created_date=" + created_date +
                ", user=" + user.getFirstName()+ " "+ user.getLastName() +
                ", skills=" + skills +
                ", projects=" + projects +
                ", experiences=" + experiences +
                ", educations=" + educations +
                '}';
    }
}
