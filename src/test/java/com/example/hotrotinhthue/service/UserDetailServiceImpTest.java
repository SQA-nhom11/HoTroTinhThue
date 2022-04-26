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
public class UserDetailServiceImpTest {
	@Autowired
	private UserDetailServiceImp userDetailServiceImp;
	
	@Test
	public void loadUserByUsername_test() {
		String username="123";
		NguoiDung nguoiDung=new NguoiDung(1, "123", "$2a$04$5uFp1c9B8L5RXlGYX35HWeByWiYp.P6yH9dmP53pjzU.B8z.5hb3e", "Cuong ML", "Hà Tây", "123456789000", "Hà Nội", "0244315432", "cuongml@gmail.com", null);  // expected result
		assertThat(userDetailServiceImp.loadUserByUsername(username)).isEqualToIgnoringGivenFields(nguoiDung, "toKhaiThueList");
	}
}
