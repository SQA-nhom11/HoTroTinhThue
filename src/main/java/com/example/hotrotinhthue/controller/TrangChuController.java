package com.example.hotrotinhthue.controller;

import com.example.hotrotinhthue.model.MaSoThue;
import com.example.hotrotinhthue.model.NguoiDung;
import com.example.hotrotinhthue.repository.MaSoThueRepo;
import com.example.hotrotinhthue.repository.NguoiDungRepo;

import java.util.regex.Pattern;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    
    @GetMapping("error")
	public String error() {
		return "error";
	}
    
    @GetMapping("dang-ki")
    public String dangKi(Model model) {
    	model.addAttribute("nguoiDung", new NguoiDung());
    	return "dang-ki";
    }
    
    @PostMapping("dang-ki")
    public String dangKi(@Valid @ModelAttribute("nguoiDung") NguoiDung nguoiDung, BindingResult result, String nhapLaiMatKhau, Model model) {
    	MaSoThue m=maSoThueRepo.findById(nguoiDung.getMaSoThue()).orElse(null);
        System.out.println(nguoiDung);
        
        // Default validate
        if(result.hasErrors()) {
        	if(!Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,16}$", nguoiDung.getMatKhau()))
        		model.addAttribute("errorPassword", "* Mật khẩu từ 8-16 kí tự, chứa ít nhất một chữ cái và một chữ số");
        	model.addAttribute("nguoiDung", nguoiDung);
        	System.out.println("Co loi validate");
			return "dang-ki";
		}
        
        // Duplicate check
        if(nguoiDungRepo.findByMaSoThue(nguoiDung.getMaSoThue())!=null) {
    		model.addAttribute("message", "Mã số thuế đã đăng kí, vui lòng sử dụng mã số thuế khác hoặc chuyển tới trang đăng nhập!");
    		System.out.println("Ma so thue da dang ki");
    		return "dang-ki";
    	}
        
        // Data exist check
    	if(m==null || !m.getId().equals(nguoiDung.getMaSoThue())
    		||!m.getCccd().equals(nguoiDung.getCccd())
    		|| !m.getHoTen().equals(nguoiDung.getHoTen())) {
    		model.addAttribute("nguoiDung", nguoiDung);
    		model.addAttribute("message", "Dữ liệu đăng kí không tồn tại trong hệ thống!");
    		System.out.println("Du lieu dang ki khong ton tai trong he thong");
    		return "dang-ki";
    	}
    	
    	// Password check
    	if(!Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,16}$", nguoiDung.getMatKhau())) {
    		model.addAttribute("nguoiDung", nguoiDung);
    		model.addAttribute("errorPassword", "* Mật khẩu từ 8-16 kí tự, chứa ít nhất một chữ cái và một chữ số");
    		System.out.println("Mat khau khong hop le");
    		return "dang-ki";
    	}
    	
    	// Re-enter password check
    	if(!nguoiDung.getMatKhau().equals(nhapLaiMatKhau)) {
    		model.addAttribute("nguoiDung", nguoiDung);
    		model.addAttribute("errorRepassword", "* Mật khẩu nhập lại không khớp");
    		System.out.println("Mat khau khong trung nhau");
    		return "dang-ki";
    	}
    	
    	// Pass validate
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder(4);
        nguoiDung.setMatKhau(bCrypt.encode(nguoiDung.getPassword()));
    	nguoiDungRepo.save(nguoiDung);
    	model.addAttribute("message", "Đăng kí thành công, mời đăng nhập!");
        System.out.println("Dang ki thanh cong");
    	return "dang-nhap";
    }
    
    @GetMapping("dang-nhap")
    public String dangNhap() {
    	return "dang-nhap";
    }
}
