package com.example.hotrotinhthue.controller;

import com.example.hotrotinhthue.model.NguoiDung;
import com.example.hotrotinhthue.model.ToKhaiThue;
import com.example.hotrotinhthue.repository.NguoiDungRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("khai-thue")
public class KhaiThueController {

    @Autowired
    NguoiDungRepo nguoiDungRepo;
	
	@GetMapping("")
    public String index() {
    	return "khai-thue/index";
    }
	
	@GetMapping("to-khai")
    public String toKhai(Model model, Authentication authentication) {
        model.addAttribute("nguoiDung", nguoiDungRepo.getById(((NguoiDung)authentication.getPrincipal()).getId()));
        model.addAttribute("toKhaiThue", new ToKhaiThue());
    	return "khai-thue/to-khai";
    }
    
    @GetMapping("tinh-thue")
    public String tinhThue() {
    	return "khai-thue/tinh-thue";
    }
}
