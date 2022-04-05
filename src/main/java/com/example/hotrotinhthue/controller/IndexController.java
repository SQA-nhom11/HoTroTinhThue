package com.example.hotrotinhthue.controller;

import com.example.hotrotinhthue.model.BangNopThue;
import com.example.hotrotinhthue.model.NguoiNopThue;
import com.example.hotrotinhthue.model.ToKhaiThue;
import com.example.hotrotinhthue.repository.BangNopThueRepo;
import com.example.hotrotinhthue.repository.MaSoThueRepo;
import com.example.hotrotinhthue.repository.NguoiNopThueRepo;
import com.example.hotrotinhthue.repository.ToKhaiThueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    NguoiNopThueRepo nguoiNopThueRepo;

    @Autowired
    MaSoThueRepo maSoThueRepo;

    @Autowired
    ToKhaiThueRepo toKhaiThueRepo;

    @Autowired
    BangNopThueRepo bangNopThueRepo;

    @GetMapping({"/index", "/"})
    public String index(ModelMap model) {
        return "index";
    }

    @GetMapping("/user")
    public String getNguoiNopThue(ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
        List<NguoiNopThue> nguoiNopThueList = nguoiNopThueRepo.findAll();
        System.out.println(nguoiNopThueList.get(0));
        return "index";
    }

    @GetMapping("/tokhai")
    public String getToKhai(ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
        List<ToKhaiThue> toKhaiThueList = toKhaiThueRepo.findAll();
        System.out.println(toKhaiThueList.get(0));
        return "index";
    }

    @GetMapping("/bangnop")
    public String getBangNop(ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
        List<BangNopThue> bangNopThueList = bangNopThueRepo.findAll();
        System.out.println(bangNopThueList.get(0));
        return "index";
    }
}
