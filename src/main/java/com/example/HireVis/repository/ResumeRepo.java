package com.example.HireVis.repository;

import com.example.HireVis.model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepo extends JpaRepository<Resume,Integer> {
}
