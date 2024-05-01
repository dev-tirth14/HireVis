package com.example.HireVis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HireVisApplication {
	private final String linkedInJobsUrl="https://www.linkedin.com/jobs/search?keywords={KEYWORDS}&location={LOCATION}&trk=public_jobs_jobs-search-bar_search-submit&position=1&pageNum=0";

	public static void main(String[] args) {
		SpringApplication.run(HireVisApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(UserProfileRepo userRepo, ResumeRepo resumeRepo){
//		return runner->{
////			UserProfile user=new UserProfile("Tirth","Patel","dev.tirthp14@gmail.com","6475337957");
//
////			System.out.println(user);
//
//			UserProfile user=userRepo.findById(1).get();
//			System.out.println(user.getResumes());
////
//			List<Skill> skills= List.of(new Skill("Java",null),new Skill("Python",null));
//			List<WorkExperience> experiences=List.of(new WorkExperience("Software Developer","Canada",new Date(2021,5,1),new Date(2022,8,28),"I worked on APIs",new Company("IBM"),null));
//			List<Project> projects=List.of(new Project("Expensify","This project was created using React, Redux, React Router.",null));
//			List<Education> education=List.of(new Education("Ontario Tech University","BSc. Computer Science",new Date(2018,9,1),new Date(2023,4,20),3.8,null));
//
//			Resume resume=new Resume(new Date(2024,4,30),null,skills,projects,experiences,education);
//			resume.setSkills(skills);
//			resume.setProjects(projects);
//			resume.setExperiences(experiences);
//			resume.setEducations(education);
//
//			user.addResume(resume);
//			resume.setUser(user);
//
////			userRepo.save(user);
//
////			UserProfile user1=userRepo.findById(1).get();
////			System.out.println(user1.getResumes());
//
//			userRepo.save(user);
//
//		};
//	}

}
