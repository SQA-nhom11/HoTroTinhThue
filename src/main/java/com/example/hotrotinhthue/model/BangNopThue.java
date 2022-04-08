package com.example.hotrotinhthue.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "bangnopthue")
public class BangNopThue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private long soTienNop;

    private Date ngayNop;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "to_khai_thue", referencedColumnName = "id")
    private ToKhaiThue toKhaiThue;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nguoi_dung")
    private NguoiDung nguoiDung;

}
