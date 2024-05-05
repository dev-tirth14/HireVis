package com.example.HireVis.model;


import jakarta.persistence.*;

@Entity
@Table(name = "rankings")
public class Ranking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JoinColumn(name = "job_posting_id")
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private JobPosting jobPosting;

    public Ranking() {}

    public Ranking(JobPosting jobPosting) {
        this.jobPosting = jobPosting;
    }

    public int getId() {
        return id;
    }

    public JobPosting getJobPosting() {
        return jobPosting;
    }

    public void setJobPosting(JobPosting jobPosting) {
        this.jobPosting = jobPosting;
    }

    @Override
    public String toString() {
        return "Ranking{" +
                "id=" + id +
                ", jobPosting=" + jobPosting.getId() +
                '}';
    }
}
