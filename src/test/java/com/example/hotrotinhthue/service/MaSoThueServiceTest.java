package com.example.hotrotinhthue.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.hotrotinhthue.model.MaSoThue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MaSoThueServiceTest {
	@Autowired
	private MaSoThueService maSoThueService;
	
	@Test
	public void getMaSoThue_test1() {
		String id="123";
		MaSoThue maSoThue=new MaSoThue("123", "Cuong ML", "123456789000"); // expected result
		assertThat(maSoThueService.getMaSoThue(id)).isEqualTo(maSoThue);
	}
	
	@Test
	public void getMaSoThue_test2() {
		String id="333";
		MaSoThue maSoThue=null; // expected result
		assertThat(maSoThueService.getMaSoThue(id)).isEqualTo(maSoThue);
	}
}
