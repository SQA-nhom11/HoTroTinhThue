package com.example.hotrotinhthue.controller;

import com.example.hotrotinhthue.model.MaSoThue;
import com.example.hotrotinhthue.model.NguoiDung;
import com.example.hotrotinhthue.repository.MaSoThueRepo;
import com.example.hotrotinhthue.repository.NguoiDungRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TrangChuController {
    @Autowired
    NguoiDungRepo nguoiDungRepo;

    @Autowired
    MaSoThueRepo maSoThueRepo;

    @GetMapping({"index", "/"})
    public String index() {
        return "index";
    }
    
    @GetMapping("dang-ki")
    public String dangKi(Model model) {
    	model.addAttribute("nguoiDung", new NguoiDung());
    	return "dang-ki";
    }
    
    @PostMapping("dang-ki")
    public String dangKi(@ModelAttribute("NguoiNopThue") NguoiDung nguoiDung, Model model) {
    	MaSoThue m=maSoThueRepo.findById(nguoiDung.getMaSoThue()).orElse(null);
        System.out.println(nguoiDung);
    	if(m==null || !m.getId().equals(nguoiDung.getMaSoThue())
    		||!m.getCccd().equals(nguoiDung.getCccd())
    		|| !m.getHoTen().equals(nguoiDung.getHoTen())) {
    		model.addAttribute("nguoiNopThue", nguoiDung);
    		model.addAttribute("statusDangKi", "Dữ liệu đăng kí không tồn tại trong hệ thống!");
    		System.out.println("Du lieu dang ki khong ton tai trong he thong");
    		return "dang-ki";
    	}

        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder(4);
        nguoiDung.setMatKhau(bCrypt.encode(nguoiDung.getPassword()));
    	nguoiDungRepo.save(nguoiDung);
    	model.addAttribute("statusDangKi", "Đăng kí thành công!");
        System.out.println("Dang ki thanh cong");
    	return "index";
    }
    
    @GetMapping("dang-nhap")
    public String dangNhap() {
    	return "dang-nhap";
    }
}
