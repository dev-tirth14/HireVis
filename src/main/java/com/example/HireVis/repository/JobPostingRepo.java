package com.example.HireVis.repository;


import com.example.HireVis.model.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostingRepo extends JpaRepository<JobPosting, String> {
}
