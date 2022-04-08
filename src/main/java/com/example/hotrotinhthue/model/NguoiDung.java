package com.example.hotrotinhthue.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@Table(name = "nguoidung")
public class NguoiDung implements UserDetails {
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String maSoThue;

    @Column(nullable = false)
    private String matKhau;

    @Column(nullable = false)
    private String hoTen;
    
    private String diaChi;

    @Column(nullable = false)
    private String cccd;
    
    private String coQuanThue;

    private String sdt;

    private String email;

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
		return maSoThue;
	}


//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nguoiDung")
//    private List<ToKhaiThue> toKhaiThueList = new ArrayList<>();
//
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nguoiDung")
//    private List<BangNopThue> bangNopThueList = new ArrayList<>();

}
