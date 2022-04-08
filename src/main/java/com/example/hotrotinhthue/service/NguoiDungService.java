package com.example.hotrotinhthue.service;

import com.example.hotrotinhthue.model.NguoiDung;
import com.example.hotrotinhthue.repository.NguoiDungRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class NguoiDungService {
    @PersistenceContext
    protected EntityManager entityManager;

    @Autowired
    NguoiDungRepo nguoiDungRepo;

    public NguoiDung loadUserByUsername(String maSoThue) {
        try {
            return (NguoiDung)nguoiDungRepo.findByMaSoThue(maSoThue);
        } catch (Exception e) {
            return null;
        }
    }
}
