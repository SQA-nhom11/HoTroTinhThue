package com.example.hotrotinhthue.service;

import com.example.hotrotinhthue.model.NguoiNopThue;
import com.example.hotrotinhthue.repository.NguoiNopThueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class NguoiNopThueService {
    @PersistenceContext
    protected EntityManager entityManager;

    @Autowired
    NguoiNopThueRepo nguoiNopThueRepo;

    public NguoiNopThue loadUserByUsername(String maSoThue) {
        try {
            return (NguoiNopThue)nguoiNopThueRepo.findByMaSoThueId(maSoThue);
        } catch (Exception e) {
            return null;
        }
    }
}
