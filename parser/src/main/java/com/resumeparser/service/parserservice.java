package com.resumeparser.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.tomcat.util.collections.CaseInsensitiveKeyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.resume.parser.parser.model.Resume;

@Service
public class parserservice {
	@Autowired
	private Resume resume;
	public Resume parsingFile(String filePath){
		String pdfText="";
		
		 try {
	            // Load the PDF document
			 PDDocument document = PDDocument.load(new File(filePath));
			 
			 // Instantiate PDFTextStripper to extract text from the document
	            PDFTextStripper pdfStripper = new PDFTextStripper();

	            // Extract text from the PDF document
	             pdfText = pdfStripper.getText(document);
	            // Close the document to free resources
	            document.close();
				
				 ArrayList<String> words=extractName(pdfText);
				 if(words.get(0)!=null||words.get(0).equals("Email")) {
				 resume.setName(words.get(0));
				 
				 String mail=(extractEmail(pdfText));
				 if(!Character.isDigit(mail.charAt(0))||Character.isLetter(mail.charAt(0))) {
					 mail=mail.substring(1);
					 resume.setEmail(mail);
				 }
				 resume.setMobilenumber(extractNumber(pdfText));
				 
				resume.setLinkedIn(extractLinkedUrl(pdfText));

			
				 resume.setGitHub(extractGithubUrl(pdfText));
				 String res=extractEducationalDetails(pdfText);
				 resume.setEducation(res);
				 
				 resume.setSkills(extractSkillsDetails(pdfText));
				 
				 resume.setProjects(extractProjectsdetails(pdfText));
	}}
     catch (IOException e) {
        e.printStackTrace();
    }
		return resume;
	}
	
	public ArrayList<String> extractName(String pdfText) { // TODO Auto-generated
		  ArrayList<String> list=new ArrayList<String>(); 
		  String Regex="\\w*\\n*\\D"; 
		  Pattern pattern=Pattern.compile(Regex); 
		  Matcher matcher=pattern.matcher(pdfText);
		 
		  if(matcher.find()) { 
			  list.add(matcher.group());
		 } 
		  return list;
		 }
	public String extractEmail(String pdfText) {
				// TODO Auto-generated method stub
			 String res="";
			 String Regex="\\S+@\\S+";
			 Pattern pattern=Pattern.compile(Regex);
			 Matcher matcher=pattern.matcher(pdfText);
			 
			 if(matcher.find()) 
				res= matcher.group();
			return res;
		}
	public long extractNumber(String pdfText) {
			// TODO Auto-generated method stub
		long result = 0;
		String Regex="\\d{10,13}";
		Pattern pattern=Pattern.compile(Regex);
		Matcher matcher=pattern.matcher(pdfText);
		
		if(matcher.find()) {
			result=Long.parseLong(matcher.group());
		}
		
			return result;
		}
	
	public String extractLinkedUrl(String pdfText) {
		// TODO Auto-generated method stub
		String url="";
		String Regex="(https?://)?(www\\.)?linkedin\\.com/in/[\\w-]+";
		Pattern pattern=Pattern.compile(Regex);
		Matcher matcher=pattern.matcher(pdfText);
		
		if(matcher.find()) {
			
			url=matcher.group();
		}
		return url;
	}
	public String extractGithubUrl(String pdfText) {
		// TODO Auto-generated method stub
		
		String url="";
		String Regex="(https?://)?(www\\.)?github\\.com/[\\w-]+";
		Pattern pattern=Pattern.compile(Regex);
		Matcher matcher=pattern.matcher(pdfText);
		
		while(matcher.find()) {
			
			url=matcher.group();
		}
		return url;
	}
	public  String extractEducationalDetails(String pdfText) throws IOException {
		
		String result="";
		String Regex="(?i)\\bEducation\\b\\s*([\\s\\S]*?)(?=\\b(SKILLS|PROJECTS|EDUCATION\\s*&|$))"
				+ "";
		Pattern pattern=Pattern.compile(Regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher=pattern.matcher(pdfText);
		
		if(matcher.find()) {
			result=matcher.group();
		}
		return result;
		}
	
	public String extractSkillsDetails(String pdfText) {
		// TODO Auto-generated method stub
		
		String skill="";
		String Regex="(?i)\\bSKILLS\\b\\s*([\\s\\S]*?)(?=\\n\\s*\\b(PROJECTS|EDUCATION\\s*|&|$))";
		Pattern pattern =Pattern.compile(Regex);
		Matcher matcher=pattern.matcher(pdfText);
		
		if(matcher.find()) {
			skill=matcher.group();
		}
		
		return skill;
	}
	
	public String extractProjectsdetails(String pdfText) {
		// TODO Auto-generated method stub
		
		String project="";
		String Regex="(?i)\\bPROJECTS\\b\\s*([\\s\\S]*)\r\n"
				
				+ "";
		Pattern pattern=Pattern.compile(Regex);
		Matcher matcher=pattern.matcher(pdfText);
		
		if(matcher.find()) {
			project=matcher.group();
		}
		return project;
	}
	
	
}
