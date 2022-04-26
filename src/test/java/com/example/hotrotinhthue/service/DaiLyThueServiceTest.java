package com.example.hotrotinhthue.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.hotrotinhthue.model.DaiLyThue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DaiLyThueServiceTest {
	@Autowired
	private DaiLyThueService daiLyThueService;
	
	@Test
	public void testGetDaiLyThue1() {
		String id="123";
		DaiLyThue daiLyThue=new DaiLyThue("123", "Nha sep"); // expected result
		assertThat(daiLyThueService.getDaiLyThue(id)).isEqualTo(daiLyThue);
	}
	
	@Test
	public void testGetDaiLyThue2() {
		String id="333";
		DaiLyThue daiLyThue=null; // expected result
		assertThat(daiLyThueService.getDaiLyThue(id)).isEqualTo(daiLyThue);
	}
}
