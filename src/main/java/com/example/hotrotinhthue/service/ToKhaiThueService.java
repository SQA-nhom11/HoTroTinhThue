package com.example.hotrotinhthue.service;

import java.util.regex.Pattern;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hotrotinhthue.Constants;
import com.example.hotrotinhthue.model.NguoiDung;
import com.example.hotrotinhthue.model.ToKhaiThue;
import com.example.hotrotinhthue.repository.ToKhaiThueRepo;

@Service
@Transactional
public class ToKhaiThueService implements Constants {
	@Autowired
	private ToKhaiThueRepo toKhaiThueRepo;

	@Autowired
	private NguoiDungService nguoiDungService;

	@Autowired
	private DaiLyThueService daiLyThueService;

	public ToKhaiThue initToKhaiThue(long id) {
		NguoiDung nguoiDung = nguoiDungService.getNguoiDung(id);
		ToKhaiThue toKhaiThue = new ToKhaiThue();
		toKhaiThue.setNamKeKhai(2022);
		toKhaiThue.setHoTen(nguoiDung.getHoTen());
		toKhaiThue.setMaSoThue(nguoiDung.getMaSoThue());
		toKhaiThue.setDiaChi(nguoiDung.getDiaChi());
		toKhaiThue.setSdt(nguoiDung.getSdt());
		toKhaiThue.setEmail(nguoiDung.getEmail());

		return toKhaiThue;
	}

	public ToKhaiThue step1ToKhaiThue(ToKhaiThue toKhaiThue) {
		// Default validate
		if (toKhaiThue.isDaiLyThue()) {
			if (toKhaiThue.getMaSoThueDLT().trim().equals(""))
				return null;
			if (daiLyThueService.getDaiLyThue(toKhaiThue.getMaSoThueDLT().trim()) == null)
				return null;
			if (toKhaiThue.getTenDaiLyThue().trim().equals(""))
				return null;
			if (daiLyThueService.getDaiLyThue(toKhaiThue.getMaSoThueDLT().trim()) != null
					&& !daiLyThueService.getDaiLyThue(toKhaiThue.getMaSoThueDLT().trim()).getTen()
							.equals(toKhaiThue.getTenDaiLyThue().trim()))
				return null;
			if (toKhaiThue.getDiaChiDLT().trim().equals(""))
				return null;
			if (!Pattern.matches("^\\d{10}$", toKhaiThue.getSdtDLT()))
				return null;
			if (!Pattern.matches("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$", toKhaiThue.getEmailDLT()))
				return null;
			if (toKhaiThue.getSoHopDong().trim().equals(""))
				return null;
		}

		// Pass validate
		System.out.println("Khai bao thue buoc 1 thanh cong");
		return toKhaiThue;
	}

	public ToKhaiThue step2ToKhaiThue(boolean cuTru, Long chiTieu20, Long chiTieu21, Long chiTieu24, Long chiTieu25,
			Long chiTieu26, Long chiTieu27, Long chiTieu30, ToKhaiThue toKhaiThue, long id) {
		if (toKhaiThue.getKyTinhThue().equals("Tháng")) toKhaiThue.setChiTieu23(GIAM_TRU_BAN_THAN);
		else toKhaiThue.setChiTieu23(GIAM_TRU_BAN_THAN * 3);
		if (cuTru) {
			toKhaiThue.setCuTru(true);
			toKhaiThue.setChiTieu20(chiTieu20);
			toKhaiThue.setChiTieu21(chiTieu21);
			toKhaiThue.setChiTieu24(chiTieu24.longValue());
			toKhaiThue.setChiTieu25(chiTieu25.longValue());
			toKhaiThue.setChiTieu26(chiTieu26.longValue());
			toKhaiThue.setChiTieu27(chiTieu27.longValue());
			toKhaiThue.setChiTieu22(toKhaiThue.getChiTieu23() + chiTieu24.longValue() + chiTieu25.longValue()
					+ chiTieu26.longValue() + chiTieu27.longValue());
			toKhaiThue.setChiTieu28(chiTieu20.longValue() - chiTieu21.longValue() - toKhaiThue.getChiTieu22());
			if (toKhaiThue.getChiTieu28() < 0) toKhaiThue.setChiTieu28(0);
			toKhaiThue.setChiTieu29(tongThue(toKhaiThue.getChiTieu28(), toKhaiThue.getKyTinhThue()));
			toKhaiThue.setChiTieu30(0);
			toKhaiThue.setChiTieu31(20);
			toKhaiThue.setChiTieu32(0);
		} else {
			toKhaiThue.setCuTru(false);
			toKhaiThue.setChiTieu20(0);
			toKhaiThue.setChiTieu21(0);
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
			toKhaiThue.setChiTieu32((long) chiTieu30.longValue() * THUE_SUAT_KHONG_CU_TRU / 100);
		}
		toKhaiThue.setNguoiDung(nguoiDungService.getNguoiDung(id));
		System.out.println("Khai bao thue thanh cong");
		return toKhaiThueRepo.save(toKhaiThue);
	}
	
	public ToKhaiThue checkToKhai(long idToKhai, long idNguoiDung) {
		NguoiDung nguoiDung=nguoiDungService.getNguoiDung(idNguoiDung);
		for(ToKhaiThue toKhaiThue:nguoiDung.getToKhaiThueList())
			if(toKhaiThue.getId()==idToKhai) return toKhaiThue;
		return null;	
	}

	public long tongThue(long tong, String kyTinhThue) {
		long thueThuNhapCaNhan = 0;
		if (kyTinhThue.equals("Tháng")) {
			if (tong <= THU_NHAP_BAC_1)
				thueThuNhapCaNhan = (tong * THUE_SUAT_BAC_1 / 100);
			else if (tong <= THU_NHAP_BAC_2)
				thueThuNhapCaNhan = (tong * THUE_SUAT_BAC_2 / 100 - 250000);
			else if (tong <= THU_NHAP_BAC_3)
				thueThuNhapCaNhan = (tong * THUE_SUAT_BAC_3 / 100 - 750000);
			else if (tong <= THU_NHAP_BAC_4)
				thueThuNhapCaNhan = (tong * THUE_SUAT_BAC_4 / 100 - 1650000);
			else if (tong <= THU_NHAP_BAC_5)
				thueThuNhapCaNhan = (tong * THUE_SUAT_BAC_5 / 100 - 3250000);
			else if (tong <= THU_NHAP_BAC_6)
				thueThuNhapCaNhan = (tong * THUE_SUAT_BAC_6 / 100 - 5850000);
			else
				thueThuNhapCaNhan = (tong * THUE_SUAT_BAC_7 / 100 - 9850000);
		} else {
			if (tong <= THU_NHAP_BAC_1)
				thueThuNhapCaNhan = (tong * THUE_SUAT_BAC_1 / 100);
			else if (tong <= THU_NHAP_BAC_2)
				thueThuNhapCaNhan = (tong * THUE_SUAT_BAC_2 / 100 - 250000 * 3);
			else if (tong <= THU_NHAP_BAC_3)
				thueThuNhapCaNhan = (tong * THUE_SUAT_BAC_3 / 100 - 750000 * 3);
			else if (tong <= THU_NHAP_BAC_4)
				thueThuNhapCaNhan = (tong * THUE_SUAT_BAC_4 / 100 - 1650000 * 3);
			else if (tong <= THU_NHAP_BAC_5)
				thueThuNhapCaNhan = (tong * THUE_SUAT_BAC_5 / 100 - 3250000 * 3);
			else if (tong <= THU_NHAP_BAC_6)
				thueThuNhapCaNhan = (tong * THUE_SUAT_BAC_6 / 100 - 5850000 * 3);
			else
				thueThuNhapCaNhan = (tong * THUE_SUAT_BAC_7 / 100 - 9850000 * 3);
		}
		return thueThuNhapCaNhan;
	}
}
