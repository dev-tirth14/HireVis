# HireVis

## Description:
HireVis is a personalized job search tool developed to streamline the process of finding relevant job postings. Leveraging the power of Large Language Models (OpenAI) and web scraping, HireVis automates the job search process by fetching, ranking, and storing job listings that match the user's profile and preferences.

## Features:
- User Profile Management: Users can create and manage their profiles, including uploading their resumes.
- Job Posting Retrieval: HireVis retrieves job postings from LinkedIN posted within the last 24 hours based on specified keywords and location.
- Ranking Service: Using OpenAI, HireVis ranks job postings based on their relevancy to the user's resume.
- Database Integration: MySQL is used for storing user profiles, resumes, job postings, and ranking information.
- API Integration: HireVis integrates with various APIs to fetch job postings and perform resume analysis.

## Technologies Used:
- Spring Boot
- MySQL: Utilized for storing user, resume, job posting, and ranking information.
- OpenAI API: Utilized for ranking job postings based on resume relevancy.
- JSoup: Web Utilized for scraping job postings off of LinkedIn.
- RESTful API: Utilized for communicating with the application.

## Benefits:
- Time-saving: Eliminates the need for manual job search by automating the process.
- Personalized: Tailors job recommendations based on the user's skills and preferences.
- Efficient: Provides a centralized platform for managing job search activities.

## Future Enhancements:
- Frontend Integration: Add a Frontend for improved user experience.
- Integration with Additional Job Portals: Extend support for fetching job postings from other job portals.
- Automation for Scheduled Scraping: Add a CronJob for scraping LinkedIn jobs once a day so users can automatically be presented with new jobs every morning.
- Customized Emails: Implement email notifications for new job postings matching the user's profile which got scraped by the CronJob.
