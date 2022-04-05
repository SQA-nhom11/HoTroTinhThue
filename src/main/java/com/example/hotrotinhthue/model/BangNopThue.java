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

    @Column(name = "so_tien_nop")
    private long soTienNop;

    @Column(name = "ngay_nop")
    private Date ngayNop;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "to_khai_thue", referencedColumnName = "id")
    private ToKhaiThue toKhaiThue;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nguoi_nop_thue")
    private NguoiNopThue nguoiNopThue;

}
