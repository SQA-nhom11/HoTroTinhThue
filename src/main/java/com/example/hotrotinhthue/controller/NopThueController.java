package com.example.hotrotinhthue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.hotrotinhthue.model.NguoiDung;
import com.example.hotrotinhthue.model.ToKhaiThue;
import com.example.hotrotinhthue.repository.NguoiDungRepo;

@Controller
@RequestMapping("nop-thue")
public class NopThueController {
	
	@Autowired
    NguoiDungRepo nguoiDungRepo;
	
	@GetMapping("")
    public String index(Model model, Authentication authentication) {
		model.addAttribute("nguoiDung", nguoiDungRepo.getById(((NguoiDung)authentication.getPrincipal()).getId()));
    	return "nop-thue/index";
    }
	
	@PostMapping("xem-lai-to-khai")
	public String xemLaiToKhai(Model model, long idToKhai, Authentication authentication) {
		NguoiDung nguoiDung=nguoiDungRepo.getById(((NguoiDung)authentication.getPrincipal()).getId());
		for(ToKhaiThue toKhaiThue:nguoiDung.getToKhaiThueList())
			if(toKhaiThue.getId()==idToKhai) {
				model.addAttribute("toKhaiThue", toKhaiThue);
				return "nop-thue/xem-lai-to-khai";
			}
		model.addAttribute("message", "Tờ khai không hợp lệ!");
		return "nop-thue/index";
	}
	
	@PostMapping("thong-tin-dong-thue")
	public String thongTinDongThue(Model model, long id, Authentication authentication) {
		NguoiDung nguoiDung=nguoiDungRepo.getById(((NguoiDung)authentication.getPrincipal()).getId());
		for(ToKhaiThue toKhaiThue:nguoiDung.getToKhaiThueList())
			if(toKhaiThue.getId()==id) {
				model.addAttribute("toKhaiThue", toKhaiThue);
				return "nop-thue/thong-tin-dong-thue";
			}
		model.addAttribute("message", "Tờ khai không hợp lệ!");
		return "nop-thue/index";
	}
}
