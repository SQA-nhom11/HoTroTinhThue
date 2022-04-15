package com.example.hotrotinhthue.controller;

import com.example.hotrotinhthue.model.NguoiDung;
import com.example.hotrotinhthue.model.ToKhaiThue;
import com.example.hotrotinhthue.repository.NguoiDungRepo;
import com.example.hotrotinhthue.repository.ToKhaiThueRepo;

import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("khai-thue")
public class KhaiThueController {

	@Autowired
	NguoiDungRepo nguoiDungRepo;
	
	@Autowired
	ToKhaiThueRepo toKhaiThueRepo;

	@GetMapping("")
	public String index() {
		return "khai-thue/index";
	}

	@GetMapping("to-khai")
	public String toKhai(Model model, Authentication authentication) {
		NguoiDung nguoiDung=nguoiDungRepo.getById(((NguoiDung) authentication.getPrincipal()).getId());
		// init data form
		ToKhaiThue toKhaiThue=new ToKhaiThue();
		toKhaiThue.setNamKeKhai(2022);
		toKhaiThue.setHoTen(nguoiDung.getHoTen());
		toKhaiThue.setMaSoThue(nguoiDung.getMaSoThue());
		toKhaiThue.setDiaChi(nguoiDung.getDiaChi());
		toKhaiThue.setSdt(nguoiDung.getSdt());
		toKhaiThue.setEmail(nguoiDung.getEmail());
		model.addAttribute("toKhaiThue", toKhaiThue);
		return "khai-thue/to-khai";
	}

	@PostMapping("to-khai")
	public String toKhai(@ModelAttribute("toKhaiThue") ToKhaiThue toKhaiThue, HttpSession session, Model model) {
		System.out.println(toKhaiThue);
		
		// Default validate
		boolean valid=true;
		if(toKhaiThue.isDaiLyThue()) {
			if(toKhaiThue.getTenDaiLyThue().trim().equals("")) {
	        	model.addAttribute("errorTenDaiLyThue", "* Trường không để trống");
	        	valid=false;
	        }
	        	
			if(toKhaiThue.getMaSoThueDLT().trim().equals("")) {
	        	model.addAttribute("errorMaSoThueDLT", "* Trường không để trống");
	        	valid=false;
	        }
			
			if(toKhaiThue.getDiaChiDLT().trim().equals("")) {
	        	model.addAttribute("errorDiaChiDLT", "* Trường không để trống");
	        	valid=false;
	        }
	        	
	        if(!Pattern.matches("^[0-9]+$", toKhaiThue.getSdtDLT())) {
	        	model.addAttribute("errorSdtDLT", "* Số điện thoại không hợp lệ");
	        	valid=false;
	        }
	        	
	        if(!Pattern.matches("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$", toKhaiThue.getEmailDLT())) {
	        	model.addAttribute("errorEmailDLT", "* Email không hợp lệ");
	        	valid=false;
	        }
	        
	        if(toKhaiThue.getSoHopDong().trim().equals("")) {
	        	model.addAttribute("errorSoHopDong", "* Trường không để trống");
	        	valid=false;
	        }
		}
		if(!valid) return "khai-thue/to-khai";
		
		// Pass validate
		session.setAttribute("toKhaiThue", toKhaiThue);
		return "khai-thue/tinh-thue";
	}

	@GetMapping("tinh-thue")
	public String tinhThue(HttpSession session) {
		if (session.getAttribute("toKhaiThue") == null)
			return "redirect:";
		return "khai-thue/tinh-thue";
	}

	@PostMapping("tinh-thue")
	public String tinhThue(boolean cuTru, Long chiTieu20, Long chiTieu21, Long chiTieu24, Long chiTieu25,
			Long chiTieu26, Long chiTieu27, Long chiTieu30, HttpSession session, Authentication authentication, Model model) {
		ToKhaiThue toKhaiThue = (ToKhaiThue) session.getAttribute("toKhaiThue");
		System.out.println(toKhaiThue);
		if (cuTru) {
			toKhaiThue.setCuTru(true);
			toKhaiThue.setChiTieu20(chiTieu20);
			toKhaiThue.setChiTieu21(chiTieu21);

			if (toKhaiThue.getKyTinhThue().equals("Tháng"))
				toKhaiThue.setChiTieu23(11000000);
			else
				toKhaiThue.setChiTieu23(33000000);
			toKhaiThue.setChiTieu24(chiTieu24.longValue());
			toKhaiThue.setChiTieu25(chiTieu25.longValue());
			toKhaiThue.setChiTieu26(chiTieu26.longValue());
			toKhaiThue.setChiTieu27(chiTieu27.longValue());
			toKhaiThue.setChiTieu22(toKhaiThue.getChiTieu23() + chiTieu24.longValue() + chiTieu25.longValue() + chiTieu26.longValue() + chiTieu27.longValue());
			toKhaiThue.setChiTieu28(chiTieu20.longValue() - chiTieu21.longValue() - toKhaiThue.getChiTieu22());
			toKhaiThue.setChiTieu29(tongThue(toKhaiThue.getChiTieu28(), toKhaiThue.getKyTinhThue()));
			toKhaiThue.setChiTieu30(0);
			toKhaiThue.setChiTieu31(20);
			toKhaiThue.setChiTieu32(0);
		} else {
			toKhaiThue.setCuTru(false);
			toKhaiThue.setChiTieu20(0);
			toKhaiThue.setChiTieu21(0);
			if (toKhaiThue.getKyTinhThue().equals("Tháng"))
				toKhaiThue.setChiTieu23(11000000);
			else
				toKhaiThue.setChiTieu23(33000000);
			toKhaiThue.setChiTieu24(0);
			toKhaiThue.setChiTieu25(0);
			toKhaiThue.setChiTieu26(0);
			toKhaiThue.setChiTieu27(0);
			toKhaiThue.setChiTieu22(0);
			toKhaiThue.setChiTieu28(0);
			toKhaiThue.setChiTieu29(0);
			toKhaiThue.setCuTru(false);
			toKhaiThue.setChiTieu30(chiTieu30.longValue());
			toKhaiThue.setChiTieu31(20);
			toKhaiThue.setChiTieu32((long) chiTieu30.longValue() * 20 / 100);
		}
		toKhaiThue.setNguoiDung(nguoiDungRepo.getById(((NguoiDung) authentication.getPrincipal()).getId()));

		// Pass validate
		toKhaiThueRepo.save(toKhaiThue);
		model.addAttribute("message", "Khai thuế thành công, mời bạn đóng thuế hoặc quay về trang chủ!");
		System.out.println("Khai bao thue thanh cong");
		return "nop-thue/index";
	}

	public long tongThue(long tong, String kyTinhThue) {
		long thueThuNhapCaNhan = 0;
		if (kyTinhThue.equals("Tháng")) {
			if (tong <= 5000000)
				thueThuNhapCaNhan = (tong * 5 / 100);
			else if (tong <= 10000000)
				thueThuNhapCaNhan = (tong * 10 / 100 - 250000);
			else if (tong <= 18000000)
				thueThuNhapCaNhan = (tong * 15 / 100 - 750000);
			else if (tong <= 32000000)
				thueThuNhapCaNhan = (tong * 20 / 100 - 1650000);
			else if (tong <= 52000000)
				thueThuNhapCaNhan = (tong * 25 / 100 - 3250000);
			else if (tong <= 80000000)
				thueThuNhapCaNhan = (tong * 30 / 100 - 5850000);
			else
				thueThuNhapCaNhan = (tong * 35 / 100 - 9850000);
		} else {
			if (tong <= 15000000)
				thueThuNhapCaNhan = (tong * 5 / 100);
			else if (tong <= 30000000)
				thueThuNhapCaNhan = (tong * 10 / 100 - 250000 * 3);
			else if (tong <= 54000000)
				thueThuNhapCaNhan = (tong * 15 / 100 - 750000 * 3);
			else if (tong <= 96000000)
				thueThuNhapCaNhan = (tong * 20 / 100 - 1650000 * 3);
			else if (tong <= 156000000)
				thueThuNhapCaNhan = (tong * 25 / 100 - 3250000 * 3);
			else if (tong <= 240000000)
				thueThuNhapCaNhan = (tong * 30 / 100 - 5850000 * 3);
			else
				thueThuNhapCaNhan = (tong * 35 / 100 - 9850000 * 3);
		}
		return thueThuNhapCaNhan;
	}
}
