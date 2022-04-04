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

    @Column(name = "soTienNop")
    private long soTienNop;

    @Column(name = "ngayNop")
    private Date ngayNop;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "toKhaiThue", referencedColumnName = "id")
    private ToKhaiThue toKhaiThue;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "maSoThue")
    private NguoiNopThue nguoiNopThue;
}
