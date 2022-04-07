package com.example.hotrotinhthue.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@Table(name = "nguoinopthue")
public class NguoiNopThue implements UserDetails {
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne()
    @JoinColumn(name = "ma_so_thue")
    private MaSoThue maSoThue;

    @Column(name = "mat_khau", nullable = false)
    private String matKhau;

    @Column(name = "ho_ten", nullable = false)
    private String hoTen;

    @Column(name = "cccd", nullable = false)
    private String cccd;

    @Column(name = "tinh_thanh")
    private String tinhThanh;

    @Column(name = "quan_huyen")
    private String quanHuyen;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "email")
    private String email;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "fax")
    private String fax;

    @Column(name = "dai_ly_thue", nullable = false)
    private boolean daiLyThue;

    @Column(name = "ten_dai_ly_thue")
    private String tenDaiLyThue;

    @Column(name = "ma_so_thue_dlt")
    private String maSoThueDLT;

    @Column(name = "tinh_thanh_dlt")
    private String tinhThanhDLT;

    @Column(name = "quan_huyen_dlt")
    private String quanHuyenDLT;

    @Column(name = "dia_chi_dlt")
    private String diaChiDLT;

    @Column(name = "email_dlt")
    private String emailDLT;

    @Column(name = "sdt_dlt")
    private String sdtDLT;

    @Column(name = "fax_dlt")
    private String faxDLT;

    @Column(name = "so_hop_dong")
    private String soHopDong;

    @Column(name = "ngay_hop_dong")
    private Date ngayHopDong;

    @Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return matKhau;
	}

	@Override
	public String getUsername() {
		return maSoThue.getId();
	}


//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nguoiNopThue")
//    private List<ToKhaiThue> toKhaiThueList = new ArrayList<>();
//
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nguoiNopThue")
//    private List<BangNopThue> bangNopThueList = new ArrayList<>();

}
