package com.example.hotrotinhthue.model;

import lombok.Data;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Entity
@Data
@Table(name = "MaSoThue")
public class MaSoThue {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "hoTen", length = 255, nullable = false)
    private String hoTen;

    @Column(name = "cccd", length = 255, nullable = false)
    private String cccd;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private NguoiNopThue nguoiNopThue;
}
