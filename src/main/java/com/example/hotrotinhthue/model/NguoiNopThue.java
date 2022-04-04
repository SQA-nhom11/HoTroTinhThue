package com.example.hotrotinhthue.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "NguoiNopThue")
@Data
public class NguoiNopThue {
    @Id
    @Column(name = "maSoThue")
    private String idMaSoThue;

    @OneToOne()
    @MapsId
    @JoinColumn(name = "maSoThue")
    private MaSoThue maSoThue;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maSoThue", fetch = FetchType.LAZY)
    private List<ToKhaiThue> toKhaiThueList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maSoThue", fetch = FetchType.LAZY)
    private List<BangNopThue> bangNopThueList = new ArrayList<>();

}
