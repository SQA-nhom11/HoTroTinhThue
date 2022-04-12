package com.example.hotrotinhthue.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "tokhaithue")
public class ToKhaiThue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "ky_tinh_thue")
    private String kyTinhThue;

    @Column(name = "quy_ke_khai")
    private int quyKeKhai;

    @Column(name = "thang_ke_khai")
    private int thangKeKhai;

    @Column(name = "nam_ke_khai")
    private int namKeKhai;

    @Column(name = "loai_to_khai")
    private String loaiToKhai;

    @Column(name = "ho_ten")
    private String hoTen;

    @Column(name = "ma_so_thue")
    private String maSoThue;

    @Column(name = "tinh_thanh")
    private String tinhThanh;

    @Column(name = "quan_huyen")
    private String quanHuyen;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "email")
    private String email;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "fax")
    private String fax;

    @Column(name = "dai_ly_thue", nullable = false)
    private boolean daiLyThue;

    @Column(name = "ten_dai_ly_thue")
    private String tenDaiLyThue;

    @Column(name = "ma_so_thue_dlt")
    private String maSoThueDLT;

    @Column(name = "tinh_thanh_dlt")
    private String tinhThanhDLT;

    @Column(name = "quan_huyen_dlt")
    private String quanHuyenDLT;

    @Column(name = "dia_chi_dlt")
    private String diaChiDLT;

    @Column(name = "email_dlt")
    private String emailDLT;

    @Column(name = "sdt_dlt")
    private String sdtDLT;

    @Column(name = "fax_dlt")
    private String faxDLT;

    @Column(name = "so_hop_dong")
    private String soHopDong;

    @Column(name = "ngay_hop_dong")
    private Date ngayHopDong;

    @Column(name = "cu_tru", nullable = false)
    private boolean cuTru;

    @Column(name = "da_nop_tien", nullable = false)
    private boolean daNopTien;

    private Date ngayNop;

    private long chiTieu20;

    private long chiTieu21;

    private long chiTieu22;

    private long chiTieu23;

    private long chiTieu24;

    private long chiTieu25;

    private long chiTieu26;

    private long chiTieu27;

    private long chiTieu28;

    private long chiTieu29;

    private long chiTieu30;

    private long chiTieu31;

    private long chiTieu32;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nguoi_dung")
    private NguoiDung nguoiDung;

}
