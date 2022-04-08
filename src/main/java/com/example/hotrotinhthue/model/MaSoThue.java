package com.example.hotrotinhthue.model;

import lombok.Data;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Entity
@Data
@Table(name = "masothue")
public class MaSoThue {
    @Id
    private String id;

    @Column(length = 255, nullable = false)
    private String hoTen;

    @Column(length = 255, nullable = false)
    private String cccd;
}
