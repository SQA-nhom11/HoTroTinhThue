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

    @Column(name = "cu_tru", nullable = false)
    private boolean cuTru;

    @Column(name = "da_nop_tien", nullable = false)
    private boolean daNopTien;

    @Column(name = "ngay_nop")
    private Date ngayNop;

    @Column(name = "chi_tieu_20")
    private long chiTieu20;

    @Column(name = "chi_tieu_21")
    private long chiTieu21;

    @Column(name = "chi_tieu_22")
    private long chiTieu22;

    @Column(name = "chi_tieu_23")
    private long chiTieu23;

    @Column(name = "chi_tieu_24")
    private long chiTieu24;

    @Column(name = "chi_tieu_25")
    private long chiTieu25;

    @Column(name = "chi_tieu_26")
    private long chiTieu26;

    @Column(name = "chi_tieu_27")
    private long chiTieu27;

    @Column(name = "chi_tieu_28")
    private long chiTieu28;

    @Column(name = "chi_tieu_29")
    private long chiTieu29;

    @Column(name = "chi_tieu_30")
    private long chiTieu30;

    @Column(name = "chi_tieu_31")
    private long chiTieu31;

    @Column(name = "chi_tieu_32")
    private long chiTieu32;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nguoi_nop_thue")
    private NguoiNopThue nguoiNopThue;

}
