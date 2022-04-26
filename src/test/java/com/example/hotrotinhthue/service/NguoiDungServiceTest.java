package com.example.hotrotinhthue.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BindingResult;

import com.example.hotrotinhthue.model.NguoiDung;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NguoiDungServiceTest {
	@Autowired
	private NguoiDungService nguoiDungService;
	
	@MockBean
	private BindingResult mockBindingResult;
	
	@Test
	public void loadUserByUsername_test() {
		// input
		String username="123";
		
		// expected result
		NguoiDung nguoiDung=new NguoiDung(1, "123", "", "Đinh Mạnh Cường", "Hà Tây", "292414832415", "Hà Nội", "0431354251", "cuongdinh@gmail.com", null);
		
		assertThat(nguoiDungService.loadUserByUsername(username)).isEqualToIgnoringGivenFields(nguoiDung, "matKhau", "toKhaiThueList");
	}
	
	// Loi validate
	@Test
	public void addNguoiDung_test1() {
		// input
		NguoiDung nguoiDung=new NguoiDung(100, "456", "matkhau", "Nguyễn Trường Giang", "Hà Đông", "174382976452", "Hà Nội", "0325395325", "giangnguyen@gmail.com", null);
		Mockito.when(mockBindingResult.hasErrors()).thenReturn(true);
		String nhapLaiMatKhau="matkhau";
		
		// expected result
		NguoiDung nguoiDungExpected=null;
		
		assertThat(nguoiDungService.addNguoiDung(nguoiDung, mockBindingResult, nhapLaiMatKhau)).isEqualTo(nguoiDungExpected);
	}
	
	// Ma so thue da dang ki
	@Test
	public void addNguoiDung_test2() {
		// input
		NguoiDung nguoiDung=new NguoiDung(1, "123", "matkhau", "Đinh Mạnh Cường", "Hà Tây", "292414832415", "Hà Nội", "02382123432", "cuonggay@gmail.com", null);
		Mockito.when(mockBindingResult.hasErrors()).thenReturn(false);
		String nhapLaiMatKhau="matkhau";
		
		// expected result
		NguoiDung nguoiDungExpected=null;
				
		assertThat(nguoiDungService.addNguoiDung(nguoiDung, mockBindingResult, nhapLaiMatKhau)).isEqualTo(nguoiDungExpected);
	}
	
	// Ma so thue khong ton tai
	@Test
	public void addNguoiDung_test3() {
		// input
		NguoiDung nguoiDung=new NguoiDung(100, "539953", "matkhau", "Nguyễn Trường Giang", "Hà Đông", "174382976452", "Hà Nội", "0325395325", "giangnguyen@gmail.com", null);
		Mockito.when(mockBindingResult.hasErrors()).thenReturn(false);
		String nhapLaiMatKhau="matkhau";
				
		// expected result
		NguoiDung nguoiDungExpected=null;
				
		assertThat(nguoiDungService.addNguoiDung(nguoiDung, mockBindingResult, nhapLaiMatKhau)).isEqualTo(nguoiDungExpected);
	}
	
	// Thong tin ho va ten hoac CCCD khong dung voi ma so thue
	@Test
	public void addNguoiDung_test4() {
		// input
		NguoiDung nguoiDung=new NguoiDung(100, "456", "matkhau", "Trần Duy Hưng", "Hà Đông", "174382976452", "Hà Nội", "0325395325", "duyhung24@gmail.com", null);
		Mockito.when(mockBindingResult.hasErrors()).thenReturn(false);
		String nhapLaiMatKhau="matkhau";
						
		// expected result
		NguoiDung nguoiDungExpected=null;
						
		assertThat(nguoiDungService.addNguoiDung(nguoiDung, mockBindingResult, nhapLaiMatKhau)).isEqualTo(nguoiDungExpected);
	}
	
	// Mat khau khong hop le
	@Test
	public void addNguoiDung_test5() {
		// input
		NguoiDung nguoiDung=new NguoiDung(100, "456", "mk", "Nguyễn Trường Giang", "Hà Đông", "174382976452", "Hà Nội", "0325395325", "giangnguyen@gmail.com", null);
		Mockito.when(mockBindingResult.hasErrors()).thenReturn(false);
		String nhapLaiMatKhau="mk";
						
		// expected result
		NguoiDung nguoiDungExpected=null;
						
		assertThat(nguoiDungService.addNguoiDung(nguoiDung, mockBindingResult, nhapLaiMatKhau)).isEqualTo(nguoiDungExpected);
	}
	
	// Mat khau khong trung nhau
	@Test
	public void addNguoiDung_test6() {
		// input
		NguoiDung nguoiDung=new NguoiDung(100, "456", "giang456", "Nguyễn Trường Giang", "Hà Đông", "174382976452", "Hà Nội", "0325395325", "giangnguyen@gmail.com", null);
		Mockito.when(mockBindingResult.hasErrors()).thenReturn(false);
		String nhapLaiMatKhau="cuonggay123";
						
		// expected result
		NguoiDung nguoiDungExpected=null;
						
		assertThat(nguoiDungService.addNguoiDung(nguoiDung, mockBindingResult, nhapLaiMatKhau)).isEqualTo(nguoiDungExpected);
	}
	
	
	// Pass validate
	@Test
	public void addNguoiDung_test7() {
		// input
		NguoiDung nguoiDung=new NguoiDung(100, "456", "giang456", "Nguyễn Trường Giang", "Hà Đông", "174382976452", "Hà Nội", "0325395325", "giangnguyen@gmail.com", null);
		Mockito.when(mockBindingResult.hasErrors()).thenReturn(false);
		String nhapLaiMatKhau="giang456";
						
		// expected result
		NguoiDung nguoiDungExpected=new NguoiDung(100, "456", "", "Nguyễn Trường Giang", "Hà Đông", "174382976452", "Hà Nội", "0325395325", "giangnguyen@gmail.com", null);
						
		assertThat(nguoiDungService.addNguoiDung(nguoiDung, mockBindingResult, nhapLaiMatKhau)).isEqualToIgnoringGivenFields(nguoiDungExpected, "matKhau", "toKhaiThueList");
	}
	
	@Test
	public void changeNguoiDungInfo_test1() {
		
	}
	
	@Test
	public void changeNguoiDungInfo_test2() {
		
	}
	
	@Test
	public void changeNguoiDungInfo_test3() {
		
	}
	
	@Test
	public void changeNguoiDungInfo_test4() {
		
	}
	
	@Test
	public void changeNguoiDungInfo_test5() {
		
	}
	
	@Test
	public void changeNguoiDungPassword_test1() {
		
	}
	
	@Test
	public void changeNguoiDungPassword_test2() {
		
	}
	
	@Test
	public void changeNguoiDungPassword_test3() {
		
	}
	
	// nguoi dung co ton tai
	@Test
	public void getNguoiDung_test1() {
		// input
		long id=1;
		
		// expected result
		NguoiDung nguoiDung=new NguoiDung(1, "123", "", "Đinh Mạnh Cường", "Hà Tây", "292414832415", "Hà Nội", "0431354251", "cuongdinh@gmail.com", null);
		assertThat(nguoiDungService.getNguoiDung(id)).isEqualToIgnoringGivenFields(nguoiDung, "matKhau", "toKhaiThueList");
	}
	
	// nguoi dung khong ton tai
	@Test
	public void getNguoiDung_test2() {
		// input
		long id=333;
		
		// expected result
		NguoiDung nguoiDung=null;
		
		assertThat(nguoiDungService.getNguoiDung(id)).isEqualTo(nguoiDung);
	}
	
	// nguoi dung co ton tai
	@Test
	public void getNguoiDungByMaSoThue_test1() {
		// input
		String maSoThue="123";
		
		// expected result
		NguoiDung nguoiDung=new NguoiDung(1, "123", "", "Đinh Mạnh Cường", "Hà Tây", "292414832415", "Hà Nội", "0431354251", "cuongdinh@gmail.com", null);
		assertThat(nguoiDungService.getNguoiDungByMaSoThue(maSoThue)).isEqualToIgnoringGivenFields(nguoiDung, "matKhau", "toKhaiThueList");
	}
	
	// nguoi dung khong ton tai
	@Test
	public void getNguoiDungByMaSoThue_test2() {
		// input
		String maSoThue="333";
		
		// expected result
		NguoiDung nguoiDung=null;
		
		assertThat(nguoiDungService.getNguoiDungByMaSoThue(maSoThue)).isEqualTo(nguoiDung);
	}
}
