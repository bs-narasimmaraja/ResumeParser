package com.resume.parser.parser.model;

import org.springframework.stereotype.Component;

@Component
public class Resume {
	private String name;
	private String Email;
	private long Mobilenumber;
	private String Address;
	private String LinkedIn;
	private String GitHub;
	private String Education;
	private String Skills;
	private String Projects;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public long getMobilenumber() {
		return Mobilenumber;
	}
	public void setMobilenumber(long mobilenumber) {
		Mobilenumber = mobilenumber;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getLinkedIn() {
		return LinkedIn;
	}
	public void setLinkedIn(String linkedIn) {
		LinkedIn = linkedIn;
	}
	public String getGitHub() {
		return GitHub;
	}
	public void setGitHub(String gitHub) {
		GitHub = gitHub;
	}
	public String getEducation() {
		return Education;
	}
	public void setEducation(String education) {
		Education = education;
	}
	public String getSkills() {
		return Skills;
	}
	public void setSkills(String skills) {
		Skills = skills;
	}
	public String getProjects() {
		return Projects;
	}
	public void setProjects(String projects) {
		Projects = projects;
	}
	
	
	
	
	
}
