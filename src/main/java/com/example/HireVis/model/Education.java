package com.example.HireVis.model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "education")
public class Education {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "institution_name")
    private String institutionName;

    @Column(name = "degree_name")
    private String degreeName;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "gpa")
    private double gpa;

    @JoinColumn(name = "resume_id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {
            CascadeType.REFRESH,
            CascadeType.DETACH,
            CascadeType.PERSIST,
            CascadeType.MERGE,
    })
    private Resume resume;

    public Education(){}
    public Education(String institutionName, String degreeName, Date startDate, Date end, double gpa, Resume resume) {
        this.institutionName = institutionName;
        this.degreeName = degreeName;
        this.startDate = startDate;
        this.endDate = end;
        this.gpa = gpa;
        this.resume = resume;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getGPA() {
        return gpa;
    }

    public void setGPA(double gpa) {
        this.gpa = gpa;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    @Override
    public String toString() {
        return "Education{" +
                "id=" + id +
                ", institutionName='" + institutionName + '\'' +
                ", degreeName='" + degreeName + '\'' +
                ", startDate=" + startDate +
                ", end=" + endDate +
                ", GPA=" + gpa +
                ", resume=" + resume.getId() +
                '}';
    }
}
