package com.resume.parser.parser.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.HashMap;
import java.util.Map;

@RestController

@RequestMapping("/anant")
@CrossOrigin(origins ="http://127.0.0.1:8080/anant/resource/${randomId}")
public class UUIDController {
	@GetMapping("/resource1/{randomId}")
    public  Map<String, Object> getResource1ById(@PathVariable String randomId) {
        Map<String, Object> response = new HashMap<>();
        response.put("id", randomId);
        System.out.println("hi"+randomId);
        
        response.put("message", "Data received successfully.");
        response.put("timestamp", System.currentTimeMillis());
        System.out.println(response);
        return response;
    }
	
    @PostMapping("/resource1/{randomId}")
    public Map<String, Object> getResourceById(@PathVariable String randomId) {
        Map<String, Object> response = new HashMap<>();
        response.put("id", randomId);
        System.out.println("hi"+randomId);
        
        response.put("message", "Data received successfully.");
        response.put("timestamp", System.currentTimeMillis());
        System.out.println(response);
        return response;
    }
}