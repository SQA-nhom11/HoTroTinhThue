package com.example.hotrotinhthue.service;

import com.example.hotrotinhthue.model.NguoiDung;
import com.example.hotrotinhthue.model.ToKhaiThue;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNull;

import java.sql.Date;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BindingResult;


import static org.assertj.core.api.Assertions.*;

import com.example.hotrotinhthue.model.ToKhaiThue;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ToKhaiThueServiceTest {
	@Autowired
	private ToKhaiThueService toKhaiThueService;

	@Autowired NguoiDungService nguoiDungService;

//	@MockBean
//	private BindingResult mockBindingResult;

	//test create toKhai voi nguoi dung ton tai
	@Test
	public void initToKhaiThue_test() {
		long id=1;
		
		// expected result
		ToKhaiThue toKhaiThue=new ToKhaiThue();
		toKhaiThue.setNamKeKhai(2022);
		toKhaiThue.setHoTen("Đinh Mạnh Cường");
		toKhaiThue.setMaSoThue("123");
		toKhaiThue.setDiaChi("Hà Tây");
		toKhaiThue.setSdt("0431354251");
		toKhaiThue.setEmail("cuongdinh@gmail.com");
		
		assertThat(toKhaiThueService.initToKhaiThue(id)).isEqualTo(toKhaiThue);
	}

	//test create toKhai voi nguoi khong ton tai
	@Test
	public void initToKhaiThue_test1() {
		Long id = 123L;
		ToKhaiThue toKhaiThue = toKhaiThueService.initToKhaiThue(id);
		assertThat(toKhaiThue).isNull();
	}

	//test to khai thue fax hop le
	@Test
	public void step1ToKhaiThue_test1() {
//		NguoiDung nguoiDung=new NguoiDung(123, "1231", "", "Đinh Mạnh Cường", "Hà Tây", "292414832415", "Hà Nội", "0431354251", "cuongdinh@gmail.com", null);
//		ToKhaiThue toKhaiThue = new ToKhaiThue(123, "Tháng", 1, 1, 2022, "Lần đầu", "Đinh Mạnh Cường", "Hà Đông", "123", "Hà Nội", "Hà Đông", "cuongdinh@gmail.com", "0123456789", "",
//				false, null, null, null, null, null, null, null, null, null, null, false, new Date(System.currentTimeMillis()), 1, 0, 11000000, 11000000, 0, 0, 0, 0, 0, 0, 0, 0, 0, nguoiDung);
		Long id = 1L;
		ToKhaiThue toKhaiThue = toKhaiThueService.initToKhaiThue(id);
		toKhaiThue.setFax("1234567890");
		toKhaiThue = toKhaiThueService.step1ToKhaiThue(toKhaiThue);
		assertThat(toKhaiThue).isNotNull();
	}

	//test to khai thue fax khong hop le
	@Test
	public void step1ToKhaiThue_test2() {
		Long id = 1L;
		ToKhaiThue toKhaiThue = toKhaiThueService.initToKhaiThue(id);
		toKhaiThue.setFax("123");
		toKhaiThue = toKhaiThueService.step1ToKhaiThue(toKhaiThue);
		assertThat(toKhaiThue).isNull();
	}

	//test to khai thue co ma so thue dai ly thue de trong
	@Test
	public void step1ToKhaiThue_test3() {
		Long id = 1L;
		ToKhaiThue toKhaiThue = toKhaiThueService.initToKhaiThue(id);
		toKhaiThue.setFax("1234567890");
		toKhaiThue.setDaiLyThue(true);
		toKhaiThue.setMaSoThueDLT("");
		toKhaiThue.setTenDaiLyThue("Cuong");
		toKhaiThue.setDiaChiDLT("test");
		toKhaiThue.setTinhThanhDLT("Hà Nội");
		toKhaiThue.setQuanHuyenDLT("Hà Đông");
		toKhaiThue.setEmailDLT("abc@gmail.com");
		toKhaiThue.setSdtDLT("0123456789");
		toKhaiThue.setSoHopDong("123");
		toKhaiThue.setNgayHopDong("12-02-2022");
		toKhaiThue = toKhaiThueService.step1ToKhaiThue(toKhaiThue);
		assertThat(toKhaiThue).isNull();
	}

	//test to khai thue co ma so thue dai ly thue khong co trong database
	@Test
	public void step1ToKhaiThue_test4() {
		Long id = 1L;
		ToKhaiThue toKhaiThue = toKhaiThueService.initToKhaiThue(id);
		toKhaiThue.setFax("1234567890");
		toKhaiThue.setDaiLyThue(true);
		toKhaiThue.setMaSoThueDLT("12345");
		toKhaiThue.setTenDaiLyThue("Cuong");
		toKhaiThue.setDiaChiDLT("test");
		toKhaiThue.setTinhThanhDLT("Hà Nội");
		toKhaiThue.setQuanHuyenDLT("Hà Đông");
		toKhaiThue.setEmailDLT("abc@gmail.com");
		toKhaiThue.setSdtDLT("0123456789");
		toKhaiThue.setSoHopDong("123");
		toKhaiThue.setNgayHopDong("12-02-2022");
		toKhaiThue = toKhaiThueService.step1ToKhaiThue(toKhaiThue);
		assertThat(toKhaiThue).isNull();
	}
	
	@Test
	//test to khai thue co ten dai ly de trong
	public void step1ToKhaiThue_test5() {
		Long id = 1L;
		ToKhaiThue toKhaiThue = toKhaiThueService.initToKhaiThue(id);
		toKhaiThue.setFax("1234567890");
		toKhaiThue.setDaiLyThue(true);
		toKhaiThue.setMaSoThueDLT("12345");
		toKhaiThue.setTenDaiLyThue("");
		toKhaiThue.setDiaChiDLT("test");
		toKhaiThue.setTinhThanhDLT("Hà Nội");
		toKhaiThue.setQuanHuyenDLT("Hà Đông");
		toKhaiThue.setEmailDLT("abc@gmail.com");
		toKhaiThue.setSdtDLT("0123456789");
		toKhaiThue.setSoHopDong("123");
		toKhaiThue.setNgayHopDong("12-02-2022");
		toKhaiThue = toKhaiThueService.step1ToKhaiThue(toKhaiThue);
		assertThat(toKhaiThue).isNull();
	}

	//test to khai thue co mst va ten khong khop trong database
	@Test
	public void step1ToKhaiThue_test6() {
		Long id = 1L;
		ToKhaiThue toKhaiThue = toKhaiThueService.initToKhaiThue(id);
		toKhaiThue.setFax("1234567890");
		toKhaiThue.setDaiLyThue(true);
		toKhaiThue.setMaSoThueDLT("123");
		toKhaiThue.setTenDaiLyThue("Cuong1");
		toKhaiThue.setDiaChiDLT("test");
		toKhaiThue.setTinhThanhDLT("Hà Nội");
		toKhaiThue.setQuanHuyenDLT("Hà Đông");
		toKhaiThue.setEmailDLT("abc@gmail.com");
		toKhaiThue.setSdtDLT("0123456789");
		toKhaiThue.setSoHopDong("123");
		toKhaiThue.setNgayHopDong("12-02-2022");
		toKhaiThue = toKhaiThueService.step1ToKhaiThue(toKhaiThue);
		assertThat(toKhaiThue).isNull();
	}

	//test to khai thue co dia chi de trong
	@Test
	public void step1ToKhaiThue_test7() {
		Long id = 1L;
		ToKhaiThue toKhaiThue = toKhaiThueService.initToKhaiThue(id);
		toKhaiThue.setFax("1234567890");
		toKhaiThue.setDaiLyThue(true);
		toKhaiThue.setMaSoThueDLT("123");
		toKhaiThue.setTenDaiLyThue("Cuong");
		toKhaiThue.setDiaChiDLT("");
		toKhaiThue.setTinhThanhDLT("Hà Nội");
		toKhaiThue.setQuanHuyenDLT("Hà Đông");
		toKhaiThue.setEmailDLT("abc@gmail.com");
		toKhaiThue.setSdtDLT("0123456789");
		toKhaiThue.setSoHopDong("123");
		toKhaiThue.setNgayHopDong("12-02-2022");
		toKhaiThue = toKhaiThueService.step1ToKhaiThue(toKhaiThue);
		assertThat(toKhaiThue).isNull();
	}

	//test to khai thue co dia chi co email ko hop le
	@Test
	public void step1ToKhaiThue_test8() {
		Long id = 1L;
		ToKhaiThue toKhaiThue = toKhaiThueService.initToKhaiThue(id);
		toKhaiThue.setFax("1234567890");
		toKhaiThue.setDaiLyThue(true);
		toKhaiThue.setMaSoThueDLT("123");
		toKhaiThue.setTenDaiLyThue("Cuong");
		toKhaiThue.setDiaChiDLT("Test");
		toKhaiThue.setTinhThanhDLT("Hà Nội");
		toKhaiThue.setQuanHuyenDLT("Hà Đông");
		toKhaiThue.setEmailDLT("abccom");
		toKhaiThue.setSdtDLT("0123456789");
		toKhaiThue.setSoHopDong("123");
		toKhaiThue.setNgayHopDong("12-02-2022");
		toKhaiThue = toKhaiThueService.step1ToKhaiThue(toKhaiThue);
		assertThat(toKhaiThue).isNull();
	}

	//test to khai thue co dia chi co sdt ko hop le
	@Test
	public void step1ToKhaiThue_test9() {
		Long id = 1L;
		ToKhaiThue toKhaiThue = toKhaiThueService.initToKhaiThue(id);
		toKhaiThue.setFax("1234567890");
		toKhaiThue.setDaiLyThue(true);
		toKhaiThue.setMaSoThueDLT("123");
		toKhaiThue.setTenDaiLyThue("Cuong");
		toKhaiThue.setDiaChiDLT("Test");
		toKhaiThue.setTinhThanhDLT("Hà Nội");
		toKhaiThue.setQuanHuyenDLT("Hà Đông");
		toKhaiThue.setEmailDLT("abc@gmail.com");
		toKhaiThue.setSdtDLT("0123456");
		toKhaiThue.setSoHopDong("123");
		toKhaiThue.setNgayHopDong("12-02-2022");
		toKhaiThue = toKhaiThueService.step1ToKhaiThue(toKhaiThue);
		assertThat(toKhaiThue).isNull();
	}

	//test to khai thue co dia chi co so hop dong de trong
	@Test
	public void step1ToKhaiThue_test10() {
		Long id = 1L;
		ToKhaiThue toKhaiThue = toKhaiThueService.initToKhaiThue(id);
		toKhaiThue.setFax("1234567890");
		toKhaiThue.setDaiLyThue(true);
		toKhaiThue.setMaSoThueDLT("123");
		toKhaiThue.setTenDaiLyThue("Cuong");
		toKhaiThue.setDiaChiDLT("Test");
		toKhaiThue.setTinhThanhDLT("Hà Nội");
		toKhaiThue.setQuanHuyenDLT("Hà Đông");
		toKhaiThue.setEmailDLT("abc@gmail.com");
		toKhaiThue.setSdtDLT("0123456789");
		toKhaiThue.setSoHopDong("");
		toKhaiThue.setNgayHopDong("12-02-2022");
		toKhaiThue = toKhaiThueService.step1ToKhaiThue(toKhaiThue);
		assertThat(toKhaiThue).isNull();
	}

	//test to khai thue co ngay hop dong de trong
	@Test
	public void step1ToKhaiThue_test11() {
		Long id = 1L;
		ToKhaiThue toKhaiThue = toKhaiThueService.initToKhaiThue(id);
		toKhaiThue.setFax("1234567890");
		toKhaiThue.setDaiLyThue(true);
		toKhaiThue.setMaSoThueDLT("123");
		toKhaiThue.setTenDaiLyThue("Cuong");
		toKhaiThue.setDiaChiDLT("Test");
		toKhaiThue.setTinhThanhDLT("Hà Nội");
		toKhaiThue.setQuanHuyenDLT("Hà Đông");
		toKhaiThue.setEmailDLT("abc@gmail.com");
		toKhaiThue.setSdtDLT("0123456789");
		toKhaiThue.setSoHopDong("123");
		toKhaiThue.setNgayHopDong("");
		toKhaiThue = toKhaiThueService.step1ToKhaiThue(toKhaiThue);
		assertThat(toKhaiThue).isNull();
	}

	//test to khai thue hop le
	@Test
	public void step1ToKhaiThue_test12() {
		Long id = 1L;
		ToKhaiThue toKhaiThue = toKhaiThueService.initToKhaiThue(id);
		toKhaiThue.setFax("1234567890");
		toKhaiThue.setDaiLyThue(true);
		toKhaiThue.setMaSoThueDLT("123");
		toKhaiThue.setTenDaiLyThue("Cuong");
		toKhaiThue.setDiaChiDLT("Test");
		toKhaiThue.setTinhThanhDLT("Hà Nội");
		toKhaiThue.setQuanHuyenDLT("Hà Đông");
		toKhaiThue.setEmailDLT("abc@gmail.com");
		toKhaiThue.setSdtDLT("0123456789");
		toKhaiThue.setSoHopDong("123");
		toKhaiThue.setNgayHopDong("12-02-2022");
		toKhaiThue = toKhaiThueService.step1ToKhaiThue(toKhaiThue);
		assertThat(toKhaiThue).isNotNull();
	}

	//Test to khai co cu tru theo tháng
	@Test
	public void step2ToKhaiThue_test1() {
		Long id = 1L;
		ToKhaiThue toKhaiThue = toKhaiThueService.initToKhaiThue(id);
		toKhaiThue = toKhaiThueService.step1ToKhaiThue(toKhaiThue);
		toKhaiThue.setKyTinhThue("Tháng");
		toKhaiThue = toKhaiThueService.step2ToKhaiThue(true, 100000000l, 0l, 4400000l,
				0l, 0l, 0l, 0l, toKhaiThue, id.longValue());
		assertThat(toKhaiThue).isNotNull();
	}

	//Test to khai co cu tru theo quý
	@Test
	public void step2ToKhaiThue_test2() {
		Long id = 1L;
		ToKhaiThue toKhaiThue = toKhaiThueService.initToKhaiThue(id);
		toKhaiThue = toKhaiThueService.step1ToKhaiThue(toKhaiThue);
		toKhaiThue.setKyTinhThue("Quý");
		toKhaiThue = toKhaiThueService.step2ToKhaiThue(true, 100000000l, 0l, 4400000l,
				0l, 0l, 0l, 0l, toKhaiThue, id.longValue());
		assertThat(toKhaiThue).isNotNull();
	}

	//Test to khai khong co cu tru
	@Test
	public void step2ToKhaiThue_test3() {
		Long id = 1L;
		ToKhaiThue toKhaiThue = toKhaiThueService.initToKhaiThue(id);
		toKhaiThue = toKhaiThueService.step1ToKhaiThue(toKhaiThue);
		toKhaiThue.setKyTinhThue("Quý");
		toKhaiThue = toKhaiThueService.step2ToKhaiThue(false, 0l, 0l, 0l, 0l,
				0l, 0l, 100000000l, toKhaiThue, id.longValue());
		assertThat(toKhaiThue).isNotNull();
	}

	//Test to khai cua nguoi dung ko ton tai
	@Test
	public void checkToKhai_test1() {
		ToKhaiThue toKhaiThue = toKhaiThueService.checkToKhai(123, 123);
		assertThat(toKhaiThue).isNull();
	}

	//Test to khai khong ton tai cua nguoi dung
	@Test
	public void checkToKhai_test2() {
//		NguoiDung nguoiDung=new NguoiDung(100, "456", "giangracruoi123", "Nguyễn Trường Giang", "Hà Đông", "174382976452", "Hà Nội", "0325395325", "giangnguyen@gmail.com", null);
//		Mockito.when(mockBindingResult.hasErrors()).thenReturn(false);
//		String matKhau="giangracruoi123";
//		nguoiDungService.addNguoiDung(nguoiDung, mockBindingResult, matKhau);
		Long id = 1L;
		ToKhaiThue toKhaiThueChecked = toKhaiThueService.checkToKhai(123456, id);
		assertThat(toKhaiThueChecked).isNull();
	}

	//Test to khai ton tai cua nguoi dung
	@Test
	public void checkToKhai_test3() {
		Long id = 1L;
		ToKhaiThue toKhaiThue = toKhaiThueService.initToKhaiThue(id);
		toKhaiThue.setKyTinhThue("Tháng");
		toKhaiThue = toKhaiThueService.step1ToKhaiThue(toKhaiThue);
		toKhaiThue = toKhaiThueService.step2ToKhaiThue(true, 100000000l, 0l, 4400000l,
				0l, 0l, 0l, 0l, toKhaiThue, id);
		ToKhaiThue toKhaiThueChecked = toKhaiThueService.checkToKhai(toKhaiThue.getId(), id);
		assertThat(toKhaiThueChecked).isNotNull();
	}

	//Test thu nhap bac 1 theo thang
	@Test
	public void tongThue_test1() {
		long tongThuNhap = 100000;
		String kyTinhThue = "Tháng";
		long tongThue = toKhaiThueService.tongThue(tongThuNhap, kyTinhThue);
		assertThat(tongThue).isEqualTo(5000l);
	}

	//Test thu nhap bac 2 theo thang
	@Test
	public void tongThue_test2() {
		long tongThuNhap = 8000000;
		String kyTinhThue = "Tháng";
		long tongThue = toKhaiThueService.tongThue(tongThuNhap, kyTinhThue);
		assertThat(tongThue).isEqualTo(550000l);
	}

	//Test thu nhap bac 3 theo thang
	@Test
	public void tongThue_test3() {
		long tongThuNhap = 14000000;
		String kyTinhThue = "Tháng";
		long tongThue = toKhaiThueService.tongThue(tongThuNhap, kyTinhThue);
		assertThat(tongThue).isEqualTo(1350000L);
	}

	//Test thu nhap bac 4 theo thang
	@Test
	public void tongThue_test4() {
		long tongThuNhap = 25000000;
		String kyTinhThue = "Tháng";
		long tongThue = toKhaiThueService.tongThue(tongThuNhap, kyTinhThue);
		assertThat(tongThue).isEqualTo(3350000L);
	}

	//Test thu nhap bac 5 theo thang
	@Test
	public void tongThue_test5() {
		long tongThuNhap = 40000000;
		String kyTinhThue = "Tháng";
		long tongThue = toKhaiThueService.tongThue(tongThuNhap, kyTinhThue);
		assertThat(tongThue).isEqualTo(6750000L);
	}

	//Test thu nhap bac 6 theo thang
	@Test
	public void tongThue_test6() {
		long tongThuNhap = 60000000;
		String kyTinhThue = "Tháng";
		long tongThue = toKhaiThueService.tongThue(tongThuNhap, kyTinhThue);
		assertThat(tongThue).isEqualTo(12150000L);
	}

	//Test thu nhap bac 7 theo thang
	@Test
	public void tongThue_test7() {
		long tongThuNhap = 100000000;
		String kyTinhThue = "Tháng";
		long tongThue = toKhaiThueService.tongThue(tongThuNhap, kyTinhThue);
		assertThat(tongThue).isEqualTo(25150000L);
	}

	//Test thu nhap bac 1 theo quy
	@Test
	public void tongThue_test8() {
		long tongThuNhap = 300000;
		String kyTinhThue = "Quý";
		long tongThue = toKhaiThueService.tongThue(tongThuNhap, kyTinhThue);
		assertThat(tongThue).isEqualTo(15000l);
	}

	//Test thu nhap bac 2 theo quy
	@Test
	public void tongThue_test9() {
		long tongThuNhap = 24000000;
		String kyTinhThue = "Quý";
		long tongThue = toKhaiThueService.tongThue(tongThuNhap, kyTinhThue);
		assertThat(tongThue).isEqualTo(1650000l);
	}

	//Test thu nhap bac 3 theo quy
	@Test
	public void tongThue_test10() {
		long tongThuNhap = 42000000;
		String kyTinhThue = "Quý";
		long tongThue = toKhaiThueService.tongThue(tongThuNhap, kyTinhThue);
		assertThat(tongThue).isEqualTo(4050000L);
	}

	//Test thu nhap bac 4 theo quy
	@Test
	public void tongThue_test11() {
		long tongThuNhap = 75000000;
		String kyTinhThue = "Quý";
		long tongThue = toKhaiThueService.tongThue(tongThuNhap, kyTinhThue);
		assertThat(tongThue).isEqualTo(10050000L);
	}

	//Test thu nhap bac 5 theo quy
	@Test
	public void tongThue_test12() {
		long tongThuNhap = 120000000;
		String kyTinhThue = "Quý";
		long tongThue = toKhaiThueService.tongThue(tongThuNhap, kyTinhThue);
		assertThat(tongThue).isEqualTo(20250000L);
	}

	//Test thu nhap bac 6 theo quy
	@Test
	public void tongThue_test13() {
		long tongThuNhap = 180000000;
		String kyTinhThue = "Quý";
		long tongThue = toKhaiThueService.tongThue(tongThuNhap, kyTinhThue);
		assertThat(tongThue).isEqualTo(36450000L);
	}

	//Test thu nhap bac 7 theo quy
	@Test
	public void tongThue_test14() {
		long tongThuNhap = 300000000;
		String kyTinhThue = "Quý";
		long tongThue = toKhaiThueService.tongThue(tongThuNhap, kyTinhThue);
		assertThat(tongThue).isEqualTo(75450000L);
	}
}
