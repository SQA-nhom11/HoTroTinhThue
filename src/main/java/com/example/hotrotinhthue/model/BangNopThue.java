package com.example.hotrotinhthue.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "BangNopThue")
public class BangNopThue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "maSoThue")
    private String maSoThue;

    @Column(name = "toKhaiThue")
    private int toKhaiThue;

    @Column(name = "soTienNop")
    private long soTienNop;

    @Column(name = "ngayNop")
    private Date ngayNop;
}
