package com.example.hotrotinhthue.controller;

import com.example.hotrotinhthue.model.MaSoThue;
import com.example.hotrotinhthue.model.NguoiDung;
import com.example.hotrotinhthue.repository.MaSoThueRepo;
import com.example.hotrotinhthue.repository.NguoiDungRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("masothue")
public class MaSoThueController {
    @Autowired
    MaSoThueRepo maSoThueRepo;

    @Autowired
    NguoiDungRepo nguoiDungRepo;

    @GetMapping("")
    public MaSoThue getOne(@RequestParam String maSoThue) {
        try {
            return maSoThueRepo.findById(maSoThue).get();
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/ton-tai")
    public boolean getNguoiDung(@RequestParam String maSoThue) {
        try {
            NguoiDung nguoiDung = nguoiDungRepo.findByMaSoThue(maSoThue);
            if(nguoiDung != null) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
