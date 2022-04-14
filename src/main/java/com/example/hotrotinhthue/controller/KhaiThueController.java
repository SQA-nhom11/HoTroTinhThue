package com.example.hotrotinhthue.controller;

import com.example.hotrotinhthue.model.NguoiDung;
import com.example.hotrotinhthue.model.ToKhaiThue;
import com.example.hotrotinhthue.repository.NguoiDungRepo;
import com.example.hotrotinhthue.repository.ToKhaiThueRepo;

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
		model.addAttribute("nguoiDung", nguoiDungRepo.getById(((NguoiDung) authentication.getPrincipal()).getId()));
		model.addAttribute("toKhaiThue", new ToKhaiThue());
		return "khai-thue/to-khai";
	}

	@PostMapping("to-khai")
	public String toKhai(@ModelAttribute("toKhaiThue") ToKhaiThue toKhaiThue, HttpSession session, Model model) {
		System.out.println(toKhaiThue);
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
	public String tinhThue(boolean cuTru, long chiTieu20, long chiTieu21, long chiTieu24, long chiTieu25,
			long chiTieu26, long chiTieu27, long chiTieu30, HttpSession session, Authentication authentication, Model model) {
		ToKhaiThue toKhaiThue = (ToKhaiThue) session.getAttribute("toKhaiThue");
		if (cuTru) {
			toKhaiThue.setCuTru(true);
			toKhaiThue.setChiTieu20(chiTieu20);
			toKhaiThue.setChiTieu21(chiTieu21);

			if (toKhaiThue.getKyTinhThue().equals("Tháng"))
				toKhaiThue.setChiTieu23(11000000);
			else
				toKhaiThue.setChiTieu23(33000000);
			toKhaiThue.setChiTieu24(chiTieu24);
			toKhaiThue.setChiTieu25(chiTieu25);
			toKhaiThue.setChiTieu26(chiTieu26);
			toKhaiThue.setChiTieu27(chiTieu27);
			toKhaiThue.setChiTieu22(toKhaiThue.getChiTieu23() + chiTieu24 + chiTieu25 + chiTieu26 + chiTieu27);
			toKhaiThue.setChiTieu28(chiTieu20 - chiTieu21 - toKhaiThue.getChiTieu22());
			toKhaiThue.setChiTieu29(tongThue(toKhaiThue.getChiTieu28(), toKhaiThue.getKyTinhThue()));
		} else {
			toKhaiThue.setCuTru(false);
			toKhaiThue.setChiTieu30(chiTieu30);
			toKhaiThue.setChiTieu31(20);
			toKhaiThue.setChiTieu32((long) chiTieu30 * 20 / 100);
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
