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
	
	@Test
	public void step1ToKhaiThue_test1() {
		
	}
	
	@Test
	public void step1ToKhaiThue_test2() {
		
	}
	
	@Test
	public void step1ToKhaiThue_test3() {
		
	}
	
	@Test
	public void step1ToKhaiThue_test4() {
		
	}
	
	@Test
	public void step1ToKhaiThue_test5() {
		
	}
	
	@Test
	public void step1ToKhaiThue_test6() {
		
	}
	
	@Test
	public void step1ToKhaiThue_test7() {
		
	}
	
	@Test
	public void step1ToKhaiThue_test8() {
		
	}
	
	@Test
	public void step1ToKhaiThue_test9() {
		
	}
	
	@Test
	public void step1ToKhaiThue_test10() {
		
	}
	
	@Test
	public void step2ToKhaiThue_test1() {
		
	}
	
	@Test
	public void step2ToKhaiThue_test2() {
		
	}
	
	@Test
	public void step2ToKhaiThue_test3() {
		
	}
	
	@Test
	public void step2ToKhaiThue_test4() {
		
	}
	
	@Test
	public void step2ToKhaiThue_test5() {
		
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
	
	@Test
	public void tongThue_test1() {
		
	}
	
	@Test
	public void tongThue_test2() {
		
	}
	
	@Test
	public void tongThue_test3() {
		
	}
	
	@Test
	public void tongThue_test4() {
		
	}
	
	@Test
	public void tongThue_test5() {
		
	}
	
	@Test
	public void tongThue_test6() {
		
	}
	
	@Test
	public void tongThue_test7() {
		
	}
	
	@Test
	public void tongThue_test8() {
		
	}
	
	@Test
	public void tongThue_test9() {
		
	}
	
	@Test
	public void tongThue_test10() {
		
	}
	
	@Test
	public void tongThue_test11() {
		
	}
	
	@Test
	public void tongThue_test12() {
		
	}
	
	@Test
	public void tongThue_test13() {
		
	}
	
	@Test
	public void tongThue_test14() {
		
	}
}
