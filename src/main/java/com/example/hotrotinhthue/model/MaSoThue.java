package com.example.hotrotinhthue.model;

import lombok.Data;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Entity
@Data
@Table(name = "masothue")
public class MaSoThue {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "ho_ten", length = 255, nullable = false)
    private String hoTen;

    @Column(name = "cccd", length = 255, nullable = false)
    private String cccd;
}
