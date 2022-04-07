package com.example.hotrotinhthue.service;

import com.example.hotrotinhthue.model.NguoiNopThue;
import com.example.hotrotinhthue.repository.NguoiNopThueRepo;
import com.example.hotrotinhthue.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Service
public class NguoiNopThueService {
    @PersistenceContext
    protected EntityManager entityManager;

    @Autowired
    NguoiNopThueRepo nguoiNopThueRepo;

    @Autowired
    RoleRepo roleRepo;

    public NguoiNopThue loadUserByUsername(String maSoThue) {
        try {
            String jpql = "Select u From NguoiNopThue u Where u.maSoThue.id='" + maSoThue + "'";
            Query query = entityManager.createQuery(jpql, NguoiNopThue.class);
            return (NguoiNopThue) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
