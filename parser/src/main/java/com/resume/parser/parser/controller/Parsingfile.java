package com.resume.parser.parser.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.resume.parser.parser.model.Resume;
import com.resumeparser.service.parserservice;

@RestController
public class Parsingfile {
	@Autowired
	private parserservice ps;
	@Autowired(required = true)
	private Resume resume;
	@PostMapping("/api/pathfile")
	public Resume extractFile(@RequestParam(value="path")String filePath){
		
		Resume res=ps.parsingFile(filePath);
		System.out.println(res);
		
		return resume;
	}
}
