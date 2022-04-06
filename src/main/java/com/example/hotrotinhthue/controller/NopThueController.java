package com.example.hotrotinhthue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("nop-thue")
public class NopThueController {
	@GetMapping("")
    public String khaiThue() {
    	return "nop-thue/index";
    }
}
