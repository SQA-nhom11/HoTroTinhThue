package com.example.hotrotinhthue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.hotrotinhthue.model.NguoiDung;
import com.example.hotrotinhthue.repository.NguoiDungRepo;

@Controller
@RequestMapping("nguoi-dung")
public class NguoiDungController {
	
	@Autowired
    NguoiDungRepo nguoiDungRepo;
	
	@GetMapping("")
    public String index(Model model, Authentication authentication) {
		model.addAttribute("nguoiDung", (NguoiDung) authentication.getPrincipal());
    	return "nguoi-dung/index";
    }
	
	@GetMapping("doi-mat-khau")
    public String doiMatKhau() {
    	return "nguoi-dung/doi-mat-khau";
    }
	
	@PostMapping("doi-mat-khau")
	public String doiMatKhau(Model model, String matKhauCu, String matKhauMoi, String nhapLaiMatKhau, Authentication authentication) {
		NguoiDung nguoiDung=(NguoiDung) authentication.getPrincipal();
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder(4);
		System.out.println(matKhauMoi+" "+nhapLaiMatKhau);
		
		if(!matKhauMoi.equals(nhapLaiMatKhau)) {
			model.addAttribute("message", "Mật khẩu không trùng nhau!");
			System.out.println("Mat khau khong trung nhau");
			return "nguoi-dung/doi-mat-khau";
		}
		
		nguoiDung.setMatKhau(bCrypt.encode(matKhauMoi));
		nguoiDungRepo.save(nguoiDung);
		model.addAttribute("message", "Đổi mật khẩu thành công!");
		System.out.println("Doi mat khau thanh cong");
		return "nguoi-dung/doi-mat-khau";
	}
	
	@GetMapping("doi-thong-tin")
    public String doiThongTin(Model model, Authentication authentication) {
		model.addAttribute("nguoiDung", (NguoiDung) authentication.getPrincipal());
    	return "nguoi-dung/doi-thong-tin";
    }
	
	@PostMapping("doi-thong-tin")
	public String doiThongTin(@ModelAttribute("NguoiNopThue") NguoiDung nguoiDungMoi, Model model, Authentication authentication) {
		NguoiDung nguoiDung=(NguoiDung) authentication.getPrincipal();
		nguoiDung.setDiaChi(nguoiDungMoi.getDiaChi());
		nguoiDung.setCoQuanThue(nguoiDungMoi.getCoQuanThue());
		nguoiDung.setSdt(nguoiDungMoi.getSdt());
		nguoiDung.setEmail(nguoiDungMoi.getEmail());
		
		nguoiDungRepo.save(nguoiDung);
		model.addAttribute("message", "Thay đổi thông tin thành công!");
		model.addAttribute("nguoiDung", (NguoiDung) authentication.getPrincipal());
		System.out.println("Thay doi thong tin thanh cong");
		return "nguoi-dung/doi-thong-tin";
	}
}
