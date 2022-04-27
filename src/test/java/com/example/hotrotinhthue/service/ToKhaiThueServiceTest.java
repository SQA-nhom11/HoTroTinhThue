package com.example.hotrotinhthue.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNull;

import java.sql.Date;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.hotrotinhthue.model.ToKhaiThue;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ToKhaiThueServiceTest {
	@Autowired
	private ToKhaiThueService toKhaiThueService;
	
	@Test
	public void initToKhaiThue_test() {
		// input
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
	
	// Khong dai ly thue
	@Test
	public void step1ToKhaiThue_test1() {
			
	}
	
	// Dai ly thue, ma so thue dai ly thue de trong
	@Test
	public void step1ToKhaiThue_test2() {
		
	}
	
	// Dai ly thue, ma so thue dai ly thue khong ton tai
	@Test
	public void step1ToKhaiThue_test3() {
		
	}
	
	// Dai ly thue, ten dai ly thue de trong
	@Test
	public void step1ToKhaiThue_test4() {
		
	}
	
	// Dai ly thue, ma so thue dai ly thue va ten dai ly thue khong khop
	@Test
	public void step1ToKhaiThue_test5() {
		
	}
	
	// Dai ly thue, dia chi dai ly thue de trong
	@Test
	public void step1ToKhaiThue_test6() {
		
	}
	
	// Dai ly thue, sdt dai ly thue khong hop le
	@Test
	public void step1ToKhaiThue_test7() {
		
	}
	
	// Dai ly thue, email dai ly thue khong hop le
	@Test
	public void step1ToKhaiThue_test8() {
		
	}
	
	// Dai ly thue, so hop dong dai ly thue de trong
	@Test
	public void step1ToKhaiThue_test9() {
		
	}
	
	// Pass validate
	@Test
	public void step1ToKhaiThue_test10() {
		
	}
	
	// Ki tinh thue theo thang, cu tru, tieu chi 28 nho hon 0
	@Test
	public void step2ToKhaiThue_test1() {
		
	}
	
	// Ki tinh thue theo quy, cu tru, tieu chi 28 lon hon 0
	@Test
	public void step2ToKhaiThue_test2() {
		
	}
	
	// Ki tinh thue theo thang, khong cu tru
	@Test
	public void step2ToKhaiThue_test3() {
		
	}
	
	// Ki tinh thue theo quy, khong cu tru
	@Test
	public void step2ToKhaiThue_test4() {
		
	}
	
	// Nguoi dung khong co to khai nao
	@Test
	public void checkToKhai_test1() {
		// input
		long idToKhai=2;
		long idNguoiDung=6;
		
		assertNull(toKhaiThueService.checkToKhai(idToKhai, idNguoiDung));
	}
	
	// To khai khong thuoc so huu cua nguoi dung
	@Test
	public void checkToKhai_test2() {
		// input
		long idToKhai=4;
		long idNguoiDung=1;
				
		assertNull(toKhaiThueService.checkToKhai(idToKhai, idNguoiDung));
	}
	
	// Pass validate
	@Test
	public void checkToKhai_test3() {
		// input
		long idToKhai=2;
		long idNguoiDung=1;
		
		// expected result
		ToKhaiThue toKhaiThue=new ToKhaiThue(2, "Tháng", 1, 4, 2022, "Lần đầu", "Đinh Mạnh Cường", "123", "Hà Nội", "Huyện Đan Phượng", "Hà Tây", "cuongdinh@gmail.com", "0431354251", "", false, null, null, null, null, null, null, null, null, null, null, true, new Date(0), 134000000, 0, 11000000, 11000000, 0, 0, 0, 0, 123000000, 33200000, 0, 20, 0, null);
		assertThat(toKhaiThueService.checkToKhai(idToKhai, idNguoiDung)).isEqualToIgnoringGivenFields(toKhaiThue, "ngayNop", "nguoiDung");
	}
	
	// Thang bac 1
	@Test
	public void tongThue_test1() {
		// input
		long tong=4174354;
		String kyTinhThue="Tháng";
		
		// expected result
		long thueThuNhapCaNhan=208718;
		assertThat(toKhaiThueService.tongThue(tong, kyTinhThue)).isEqualTo(thueThuNhapCaNhan);
	}
	
	// Thang bac 2
	@Test
	public void tongThue_test2() {
		// input
		long tong=9238437;
		String kyTinhThue="Tháng";
				
		// expected result
		long thueThuNhapCaNhan=673844;
		assertThat(toKhaiThueService.tongThue(tong, kyTinhThue)).isEqualTo(thueThuNhapCaNhan);
	}
	
	// Thang bac 3
	@Test
	public void tongThue_test3() {
		// input
		long tong=17928421;
		String kyTinhThue="Tháng";
				
		// expected result
		long thueThuNhapCaNhan=1939263;
		assertThat(toKhaiThueService.tongThue(tong, kyTinhThue)).isEqualTo(thueThuNhapCaNhan);
	}
	
	// Thang bac 4
	@Test
	public void tongThue_test4() {
		// input
		long tong=31284736;
		String kyTinhThue="Tháng";
				
		// expected result
		long thueThuNhapCaNhan=4606947;
		assertThat(toKhaiThueService.tongThue(tong, kyTinhThue)).isEqualTo(thueThuNhapCaNhan);
	}
	
	// Thang bac 5
	@Test
	public void tongThue_test5() {
		// input
		long tong=52294543;
		String kyTinhThue="Tháng";
				
		// expected result
		long thueThuNhapCaNhan=9838363;
		assertThat(toKhaiThueService.tongThue(tong, kyTinhThue)).isEqualTo(thueThuNhapCaNhan);
	}
	
	// Thang bac 6
	@Test
	public void tongThue_test6() {
		// input
		long tong=78947319;
		String kyTinhThue="Tháng";
				
		// expected result
		long thueThuNhapCaNhan=17834196;
		assertThat(toKhaiThueService.tongThue(tong, kyTinhThue)).isEqualTo(thueThuNhapCaNhan);
	}
	
	// Thang bac 7
	@Test
	public void tongThue_test7() {
		// input
		long tong=123456789;
		String kyTinhThue="Tháng";
				
		// expected result
		long thueThuNhapCaNhan=33359876;
		assertThat(toKhaiThueService.tongThue(tong, kyTinhThue)).isEqualTo(thueThuNhapCaNhan);
	}
	
	// Quy bac 1
	@Test
	public void tongThue_test8() {
		
	}
	
	// Quy bac 2
	@Test
	public void tongThue_test9() {
		
	}
	
	// Quy bac 3
	@Test
	public void tongThue_test10() {
		
	}
	
	// Quy bac 4
	@Test
	public void tongThue_test11() {
		
	}
	
	// Quy bac 5
	@Test
	public void tongThue_test12() {
		
	}
	
	// Quy bac 6
	@Test
	public void tongThue_test13() {
		
	}
	
	// Quy bac 7
	@Test
	public void tongThue_test14() {
		
	}
}
