package com.example.hotrotinhthue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("khai-thue")
public class KhaiThueController {
	
	@GetMapping("")
    public String khaiThue() {
    	return "khai-thue/index";
    }
	
	@GetMapping("to-khai")
    public String toKhai() {
    	return "khai-thue/to-khai";
    }
	
	@GetMapping("to-khai/dien-to-khai")
    public String dienToKhai() {
    	return "khai-thue/dien-to-khai";
    }
}
