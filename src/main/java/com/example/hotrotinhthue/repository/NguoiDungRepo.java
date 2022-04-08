package com.example.hotrotinhthue.repository;

import com.example.hotrotinhthue.model.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NguoiDungRepo extends JpaRepository<NguoiDung, String> {
	NguoiDung findByMaSoThue(String maSoThue);
}
