package com.example.hotrotinhthue.controller;

import com.example.hotrotinhthue.model.MaSoThue;
import com.example.hotrotinhthue.model.NguoiNopThue;
import com.example.hotrotinhthue.repository.MaSoThueRepo;
import com.example.hotrotinhthue.repository.NguoiNopThueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {
    @Autowired
    NguoiNopThueRepo nguoiNopThueRepo;

    @Autowired
    MaSoThueRepo maSoThueRepo;

    @GetMapping({"/index", "/"})
    public String index() {
        return "index";
    }
    
    @GetMapping("dang-ki")
    public String dangKi(Model model) {
    	model.addAttribute("nguoiNopThue", new NguoiNopThue());
    	return "index";
    }
    
    @PostMapping("dang-ki")
    public String dangKi(@ModelAttribute("NguoiNopThue") NguoiNopThue nguoinopthue, Model model) {
    	MaSoThue m=maSoThueRepo.findByCccd(nguoinopthue.getCccd());
    	if(m==null ||!m.getCccd().equals(nguoinopthue.getCccd())
    		|| !m.getHoTen().equals(nguoinopthue.getHoTen())) {
    		model.addAttribute("nguoiNopThue", nguoinopthue);
    		System.out.println("Du lieu dang ki khong ton tai trong he thong");
    		return "index";
    	}
    	
    	nguoiNopThueRepo.save(nguoinopthue);
    	return "index";
    }
    
    @GetMapping("dang-nhap")
    public String dangNhap() {
    	return "index";
    }
    

//	@GetMapping("/user")
//	public String getNguoiNopThue(ModelMap model, final HttpServletRequest request,
//			final HttpServletResponse response) {
//		List<NguoiNopThue> nguoiNopThueList = nguoiNopThueRepo.findAll();
//		System.out.println(nguoiNopThueList.get(0));
//		return "index";
//	}
//
//	@GetMapping("/tokhai")
//	public String getToKhai(ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
//		List<ToKhaiThue> toKhaiThueList = toKhaiThueRepo.findAll();
//		System.out.println(toKhaiThueList.get(0));
//		return "index";
//	}
//
//	@GetMapping("/bangnop")
//	public String getBangNop(ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
//		List<BangNopThue> bangNopThueList = bangNopThueRepo.findAll();
//		System.out.println(bangNopThueList.get(0));
//		return "index";
//	}
}
