package com.example.hotrotinhthue.service;

import static org.assertj.core.api.Assertions.assertThat;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.hotrotinhthue.model.NguoiDung;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserDetailServiceImpTest {
	@Autowired
	private UserDetailServiceImp userDetailServiceImp;
	
	@Test
	public void loadUserByUsername_test() {
		// input
		String username="123";
		
		// expected result
		NguoiDung nguoiDung=new NguoiDung(1, "123", "", "Đinh Mạnh Cường", "Hà Tây", "292414832415", "Hà Nội", "0431354251", "cuongdinh@gmail.com", null);
		
		assertThat(userDetailServiceImp.loadUserByUsername(username)).isEqualToIgnoringGivenFields(nguoiDung, "matKhau", "toKhaiThueList");
	}
}
