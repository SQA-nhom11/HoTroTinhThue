package com.example.hotrotinhthue.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.hotrotinhthue.model.DaiLyThue;
import com.example.hotrotinhthue.repository.DaiLyThueRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DaiLyThueServiceTest {	
	@Autowired
	private DaiLyThueService daiLyThueService;
	
	// dai ly thue co ton tai
	@Test
	public void getDaiLyThue_test1() {
		// input
		String id="2301016906";
		
		// expected result
		DaiLyThue daiLyThue=new DaiLyThue("2301016906", "ST TAX"); 
		
		assertThat(daiLyThueService.getDaiLyThue(id)).isEqualTo(daiLyThue);
	}
	
	// dai ly thue khong ton tai
	@Test
	public void getDaiLyThue_test2() {
		// input
		String id="333";
		
		// expected result
		DaiLyThue daiLyThue=null;
		
		assertThat(daiLyThueService.getDaiLyThue(id)).isEqualTo(daiLyThue);
	}
}
