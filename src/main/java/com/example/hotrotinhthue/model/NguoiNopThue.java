package com.example.hotrotinhthue.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "NguoiNopThue")
@Data
public class NguoiNopThue {
    @Id
    @Column(name = "nguoiNopThue")
    private String nguoiNopThue;

    @Column(name = "matKhau", nullable = false)
    private String matKhau;

    @Column(name = "hoTen", nullable = false)
    private String hoTen;

    @Column(name = "tinhThanh")
    private String tinhThanh;

    @Column(name = "quanHuyen")
    private String quanHuyen;

    @Column(name = "diaChi")
    private String diaChi;

    @Column(name = "email")
    private String email;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "fax")
    private String fax;

    @Column(name = "daiLyThue", nullable = false)
    private boolean daiLyThue;

    @Column(name = "tenDaiLyThue")
    private String tenDaiLyThue;

    @Column(name = "maSoThueDLT")
    private String maSoThueDLT;

    @Column(name = "tinhThanhDLT")
    private String tinhThanhDLT;

    @Column(name = "quanHuyenDLT")
    private String quanHuyenDLT;

    @Column(name = "diaChiDLT")
    private String diaChiDLT;

    @Column(name = "emailDLT")
    private String emailDLT;

    @Column(name = "sdtDLT")
    private String sdtDLT;

    @Column(name = "faxDLT")
    private String faxDLT;

    @Column(name = "soHopDong")
    private int soHopDong;

    @Column(name = "ngayHopDong")
    private Date ngayHopDong;
}
