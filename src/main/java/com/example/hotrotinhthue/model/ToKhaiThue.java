package com.example.hotrotinhthue.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "ToKhaiThue")
public class ToKhaiThue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "cuTru", nullable = false)
    private boolean cuTru;

    @Column(name = "daNopTien", nullable = false)
    private boolean daNopTien;

    @Column(name = "ngayNop")
    private Date ngayNop;

    @Column(name = "chiTieu20")
    private long chiTieu20;

    @Column(name = "chiTieu21")
    private long chiTieu21;

    @Column(name = "chiTieu22")
    private long chiTieu22;

    @Column(name = "chiTieu23")
    private long chiTieu23;

    @Column(name = "chiTieu24")
    private long chiTieu24;

    @Column(name = "chiTieu25")
    private long chiTieu25;

    @Column(name = "chiTieu26")
    private long chiTieu26;

    @Column(name = "chiTieu27")
    private long chiTieu27;

    @Column(name = "chiTieu28")
    private long chiTieu28;

    @Column(name = "chiTieu29")
    private long chiTieu29;

    @Column(name = "chiTieu30")
    private long chiTieu30;

    @Column(name = "chiTieu31")
    private long chiTieu31;

    @Column(name = "chiTieu32")
    private long chiTieu32;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "maSoThue")
    private NguoiNopThue nguoiNopThue;

}
