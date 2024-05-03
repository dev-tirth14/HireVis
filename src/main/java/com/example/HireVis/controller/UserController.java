package com.example.HireVis.controller;

import com.example.HireVis.dto.ResumeDTO;
import com.example.HireVis.dto.UserProfileDTO;
import com.example.HireVis.model.Resume;
import com.example.HireVis.model.UserProfile;
import com.example.HireVis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/createUser")
    public String createUser(@RequestBody UserProfileDTO userDTO) {
        // Process the DTO
        UserProfile user=userService.createUser(userDTO);
        return "User "+ user.getId()+" has been created";
    }

    @GetMapping("/users/{userId}")
    public String getUser(@PathVariable int userId) {
        // Process the DTO
        UserProfile user=userService.getUser(userId);
        if(user==null){
            return "User not found";
        }
        return "User: "+ user.toString();
    }

    @GetMapping("/resumes/{resumeId}")
    public String getResume(@PathVariable int resumeId) {
        // Process the DTO
        Resume resume=userService.getResume(resumeId);
        if(resume==null){
            return "Resume not found";
        }
        return "Resume: "+ resume.toString();
    }


    @PostMapping("/users/{userId}/createResume")
    public String createResume(@PathVariable int userId,@RequestBody ResumeDTO resumeDTO) {
        resumeDTO.setUser_id(userId);
        Resume resume=userService.createResume(resumeDTO);
        return "Resume is created: "+ resume.toString();
    }
}
