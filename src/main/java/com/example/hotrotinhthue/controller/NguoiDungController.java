package com.example.hotrotinhthue.controller;

import java.util.regex.Pattern;

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
		model.addAttribute("nguoiDung", nguoiDungRepo.getById(((NguoiDung)authentication.getPrincipal()).getId()));
    	return "nguoi-dung/index";
    }
	
	@GetMapping("doi-mat-khau")
    public String doiMatKhau() {
    	return "nguoi-dung/doi-mat-khau";
    }
	
	@PostMapping("doi-mat-khau")
	public String doiMatKhau(Model model, String matKhauMoi, String nhapLaiMatKhau, Authentication authentication) {
		NguoiDung nguoiDung=nguoiDungRepo.getById(((NguoiDung)authentication.getPrincipal()).getId());
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder(4);
		System.out.println(matKhauMoi+" "+nhapLaiMatKhau);
		
		// Password check
    	if(!Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,16}$", matKhauMoi)) {
    		model.addAttribute("message", "Mật khẩu từ 8-16 kí tự, chứa ít nhất một chữ và số");
    		System.out.println("Mat khau khong hop le");
    		return "nguoi-dung/doi-mat-khau";
    	}
		
		// Re-enter password check
		if(!matKhauMoi.equals(nhapLaiMatKhau)) {
			model.addAttribute("message", "Mật khẩu không trùng nhau!");
			System.out.println("Mat khau khong trung nhau");
			return "nguoi-dung/doi-mat-khau";
		}
		
		nguoiDung.setMatKhau(bCrypt.encode(matKhauMoi));
		nguoiDungRepo.save(nguoiDung);
		model.addAttribute("successMessage", "Đổi mật khẩu thành công!");
		System.out.println("Doi mat khau thanh cong");
		return "nguoi-dung/doi-mat-khau";
	}
	
	@GetMapping("doi-thong-tin")
    public String doiThongTin(Model model, Authentication authentication) {
		model.addAttribute("nguoiDung", nguoiDungRepo.getById(((NguoiDung)authentication.getPrincipal()).getId()));
    	return "nguoi-dung/doi-thong-tin";
    }
	
	@PostMapping("doi-thong-tin")
	public String doiThongTin(@ModelAttribute("NguoiNopThue") NguoiDung nguoiDungMoi, Model model, Authentication authentication) {
		NguoiDung nguoiDung=nguoiDungRepo.getById(((NguoiDung)authentication.getPrincipal()).getId());
		nguoiDung.setDiaChi(nguoiDungMoi.getDiaChi());
		nguoiDung.setCoQuanThue(nguoiDungMoi.getCoQuanThue());
		nguoiDung.setSdt(nguoiDungMoi.getSdt());
		nguoiDung.setEmail(nguoiDungMoi.getEmail());
		
		// Default validate
		boolean valid=true;
        if(nguoiDung.getDiaChi().trim().equals("")) {
        	model.addAttribute("errorDiaChi", "* Trường không để trống");
        	valid=false;
        }
        	
        if(nguoiDung.getCoQuanThue().trim().equals("")) {
        	model.addAttribute("errorCoQuanThue", "* Trường không để trống");
        	valid=false;
        }
        	
        if(!Pattern.matches("^[0-9]+$", nguoiDung.getSdt())) {
        	model.addAttribute("errorSdt", "* Số điện thoại không hợp lệ");
        	valid=false;
        }
        	
        if(!Pattern.matches("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$", nguoiDung.getEmail())) {
        	model.addAttribute("errorEmail", "* Email không hợp lệ");
        	valid=false;
        }
		
        if(!valid) {
        	model.addAttribute("nguoiDung", nguoiDung);
        	System.out.println("Co loi validate");
        	return "nguoi-dung/doi-thong-tin";
        }
        
        // Pass validate
		nguoiDungRepo.save(nguoiDung);
		model.addAttribute("message", "Thay đổi thông tin thành công!");
		model.addAttribute("nguoiDung", nguoiDungRepo.getById(((NguoiDung)authentication.getPrincipal()).getId()));
		System.out.println("Thay doi thong tin thanh cong");
		return "nguoi-dung/index";
	}
}
