package com.example.hotrotinhthue.controller;

import com.example.hotrotinhthue.model.MaSoThue;
import com.example.hotrotinhthue.model.NguoiNopThue;
import com.example.hotrotinhthue.model.Role;
import com.example.hotrotinhthue.repository.MaSoThueRepo;
import com.example.hotrotinhthue.repository.NguoiNopThueRepo;
import com.example.hotrotinhthue.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class TrangChuController {
    @Autowired
    NguoiNopThueRepo nguoiNopThueRepo;

    @Autowired
    MaSoThueRepo maSoThueRepo;

    @Autowired
    RoleRepo roleRepo;

    @GetMapping({"/index", "/"})
    public String index() {
        return "index";
    }
    
    @GetMapping("/dang-ki")
    public String dangKi(Model model) {
    	model.addAttribute("nguoiNopThue", new NguoiNopThue());
    	return "nguoi-dung/dang-ki";
    }
    
    @PostMapping("dang-ki")
    public String dangKi(@ModelAttribute("NguoiNopThue") NguoiNopThue nguoinopthue, Model model) {
    	MaSoThue m=maSoThueRepo.findByCccd(nguoinopthue.getCccd());
        System.out.println(nguoinopthue);
    	if(m==null ||!m.getCccd().equals(nguoinopthue.getCccd())
    		|| !m.getHoTen().equals(nguoinopthue.getHoTen())) {
    		model.addAttribute("nguoiNopThue", nguoinopthue);
    		System.out.println("Du lieu dang ki khong ton tai trong he thong");
    		return "nguoi-dung/dang-ki";
    	}
        //temp
        nguoinopthue.setDaiLyThue(false);
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder(4);
        String password = bCrypt.encode(nguoinopthue.getPassword());
    	nguoinopthue.setMatKhau(password);
        nguoinopthue.addRole(new Role());
        nguoinopthue.setRoles(getUserRole());
        nguoiNopThueRepo.save(nguoinopthue);
    	return "index";
    }

    private List<Role> getUserRole() {
        List<Role> guessRole = new ArrayList<>();
        List<Role> roles = roleRepo.findAll();
        for(Role role: roles) {
            if(role.getName().equals("USER")) {
                guessRole.add(role);
                break;
            }
        }
        return guessRole;
    }
    
    @GetMapping("/dang-nhap")
    public String dangNhap() {
    	return "nguoi-dung/dang-nhap";
    }

}
