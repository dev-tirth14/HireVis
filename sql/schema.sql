DROP SCHEMA IF EXISTS `hirevis`;

CREATE SCHEMA `hirevis`;

use `hirevis`;

SET FOREIGN_KEY_CHECKS = 0;



CREATE TABLE `user_profile` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `resume` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_date` DATE DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  
  PRIMARY KEY (`id`),
  
  KEY `FK_user_idx` (`user_id`),
  CONSTRAINT `FK_USER` FOREIGN KEY (`user_id`) 
  REFERENCES `user_profile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE

) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `skill` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  
  PRIMARY KEY (`id`)
  
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

CREATE TABLE `project` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `description` TEXT DEFAULT NULL,
  `resume_id` int DEFAULT NULL,
  
  PRIMARY KEY (`id`),
  
  KEY `FK_resume_idx` (`resume_id`),
  CONSTRAINT `FK_resume_1` FOREIGN KEY (`resume_id`) 
  REFERENCES `resume` (`id`) ON DELETE CASCADE ON UPDATE CASCADE

) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `company` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  
  PRIMARY KEY (`id`)

) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `work_experience` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(30) DEFAULT NULL,
  `location` varchar(30) DEFAULT NULL,
  `start_date` DATE DEFAULT NULL,
  `end_date` DATE DEFAULT NULL,
  `description` TEXT DEFAULT NULL,
  
  `company_id` int DEFAULT NULL,
  `resume_id` int DEFAULT NULL,
  
  PRIMARY KEY (`id`),
  
  KEY `FK_resume_idx` (`resume_id`),
  CONSTRAINT `FK_resume_2` FOREIGN KEY (`resume_id`) 
  REFERENCES `resume` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  
  KEY `FK_company_idx` (`company_id`),
  CONSTRAINT `FK_company` FOREIGN KEY (`company_id`) 
  REFERENCES `company` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION

) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `education` (
  `id` int NOT NULL AUTO_INCREMENT,
  `institution_name` varchar(30) DEFAULT NULL,
  `degree_name` varchar(30) DEFAULT NULL,
  `start_date` DATE DEFAULT NULL,
  `end_date` DATE DEFAULT NULL,
  `gpa` DOUBLE DEFAULT NULL,
  `resume_id` int DEFAULT NULL,
  
  PRIMARY KEY (`id`),
  
  KEY `FK_resume_idx` (`resume_id`),
  CONSTRAINT `FK_resume_3` FOREIGN KEY (`resume_id`) 
  REFERENCES `resume` (`id`) ON DELETE CASCADE ON UPDATE CASCADE

) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `job_posting` (
  `id` varchar(15) NOT NULL,
  `url` varchar(500) DEFAULT NULL,
  `role_name` varchar(100) DEFAULT NULL,
  `company_name` varchar(100) DEFAULT NULL,
  `description` TEXT DEFAULT NULL,
  
  PRIMARY KEY (`id`)

) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `resume_skill` (
  `skill_id` int NOT NULL,
  `resume_id` int NOT NULL,
  
  PRIMARY KEY (`skill_id`,`resume_id`),
  
  KEY `FK_skill_idx` (`skill_id`),
  
  CONSTRAINT `FK_skill_05` FOREIGN KEY (`skill_id`) 
  REFERENCES `skill` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_resume_4` FOREIGN KEY (`resume_id`) 
  REFERENCES `resume` (`id`) 
  ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
