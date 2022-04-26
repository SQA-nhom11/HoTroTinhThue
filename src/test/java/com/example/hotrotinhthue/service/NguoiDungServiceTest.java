package com.example.hotrotinhthue.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.hotrotinhthue.model.NguoiDung;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NguoiDungServiceTest {
	@Autowired
	private NguoiDungService nguoiDungService;
	
	@Test
	public void loadUserByUsername_test() {
		String username="123";
		NguoiDung nguoiDung=new NguoiDung(1, "123", "$2a$04$5uFp1c9B8L5RXlGYX35HWeByWiYp.P6yH9dmP53pjzU.B8z.5hb3e", "Cuong ML", "Hà Tây", "123456789000", "Hà Nội", "0244315432", "cuongml@gmail.com", null);  // expected result
		assertThat(nguoiDungService.loadUserByUsername(username)).isEqualToIgnoringGivenFields(nguoiDung, "toKhaiThueList");
	}
	
	@Test
	public void getNguoiDung_test1() {
		long id=1;
		NguoiDung nguoiDung=new NguoiDung(1, "123", "$2a$04$5uFp1c9B8L5RXlGYX35HWeByWiYp.P6yH9dmP53pjzU.B8z.5hb3e", "Cuong ML", "Hà Tây", "123456789000", "Hà Nội", "0244315432", "cuongml@gmail.com", null); // expected result
		assertThat(nguoiDungService.getNguoiDung(id)).isEqualToIgnoringGivenFields(nguoiDung, "toKhaiThueList");
	}
	
	@Test
	public void getNguoiDung_test2() {
		long id=999;
		NguoiDung nguoiDung=null; // expected result
		assertThat(nguoiDungService.getNguoiDung(id)).isEqualTo(nguoiDung);
	}
	
	@Test
	public void getNguoiDungByMaSoThue_test1() {
		String maSoThue="123";
		NguoiDung nguoiDung=new NguoiDung(1, "123", "$2a$04$5uFp1c9B8L5RXlGYX35HWeByWiYp.P6yH9dmP53pjzU.B8z.5hb3e", "Cuong ML", "Hà Tây", "123456789000", "Hà Nội", "0244315432", "cuongml@gmail.com", null); // expected result
		assertThat(nguoiDungService.getNguoiDungByMaSoThue(maSoThue)).isEqualToIgnoringGivenFields(nguoiDung, "toKhaiThueList");
	}
	
	@Test
	public void getNguoiDungByMaSoThue_test2() {
		String maSoThue="999";
		NguoiDung nguoiDung=null; // expected result
		assertThat(nguoiDungService.getNguoiDungByMaSoThue(maSoThue)).isEqualTo(nguoiDung);
	}
}
