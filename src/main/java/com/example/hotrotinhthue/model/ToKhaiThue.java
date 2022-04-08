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
