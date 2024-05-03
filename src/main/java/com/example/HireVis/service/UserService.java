package com.example.HireVis.service;

import com.example.HireVis.dto.ResumeDTO;
import com.example.HireVis.dto.UserProfileDTO;
import com.example.HireVis.model.*;
import com.example.HireVis.repository.ResumeRepo;
import com.example.HireVis.repository.UserProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    private UserProfileRepo userProfileRepo;
    private ResumeRepo resumeRepo;

    @Autowired
    public UserService(UserProfileRepo userProfileRepo, ResumeRepo resumeRepo){

        this.userProfileRepo=userProfileRepo;
        this.resumeRepo=resumeRepo;
    }

    public UserProfile createUser(UserProfileDTO userProfileDTO){
        UserProfile user=mapToUserProfile(userProfileDTO);
        userProfileRepo.save(user);
        return user;
    }
    public Resume createResume(ResumeDTO resumeDTO){
        UserProfile user=getUser(resumeDTO.getUser_id());
        if(user==null){
            return null;
        }
        Resume resume=mapToResume(resumeDTO);
        resume.setUser(user);
        user.addResume(resume);

        userProfileRepo.save(user);
        return user.getResumes().get(user.getResumes().size()-1);
    }

    public UserProfile getUser(int userId){
        Optional<UserProfile> user=userProfileRepo.findById(userId);
        System.out.println(user.get().getResumes());
        if(user.isEmpty()){
            return null;
        }
        return user.get();
    }
    public Resume getResume(int resumeId){
        Optional<Resume> resume=resumeRepo.findById(resumeId);
        if(resume.isEmpty()){
            return null;
        }
        return resume.get();
    }
    private UserProfile mapToUserProfile(UserProfileDTO userProfileDTO){
        return new UserProfile(
                userProfileDTO.getFirstName(),
                userProfileDTO.getLastName(),
                userProfileDTO.getEmail(),
                userProfileDTO.getPhoneNumber());
    }
    private Resume mapToResume(ResumeDTO resumeDTO){
        Resume resume=new Resume();
        resume.setCreated_date(resumeDTO.getCreated_date());
        resume.setUser(null);

        List<Skill> skills=resumeDTO.getSkills().stream().
                map(skillDTO -> new Skill(skillDTO.getName(),null)).
                toList();
        List<WorkExperience> workExperiences=resumeDTO.getExperiences().stream().
                map(experienceDTO -> new WorkExperience(
                        experienceDTO.getRoleName(),
                        experienceDTO.getLocation(),
                        experienceDTO.getStartDate(),
                        experienceDTO.getEndDate(),
                        experienceDTO.getDescription(),
                        new Company(experienceDTO.getCompany().getName()),
                        null)
                )
                .toList();
        List<Project> projects=resumeDTO.getProjects().stream().
                map(projectDTO -> new Project(
                        projectDTO.getName(),
                        projectDTO.getDescription(),
                        null)
                )
                .toList();
        List<Education> education=resumeDTO.getEducation().stream().
                map(educationDTO -> new Education(
                        educationDTO.getInstitutionName(),
                        educationDTO.getDegreeName(),
                        educationDTO.getStartDate(),
                        educationDTO.getEndDate(),
                        educationDTO.getGpa(),
                        null)
                )
                .toList();
        resume.setSkills(skills);
        resume.setExperiences(workExperiences);
        resume.setEducations(education);
        resume.setProjects(projects);

        return resume;
    }
}
