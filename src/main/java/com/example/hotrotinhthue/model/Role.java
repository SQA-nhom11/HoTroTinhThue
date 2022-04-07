package com.example.hotrotinhthue.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "role")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "roles")
    private List<NguoiNopThue> users = new ArrayList<>();

    public void addUser(NguoiNopThue user) {
        user.getRoles().add(this);
        users.add(user);
    }

    public void removeUser(NguoiNopThue user) {
        user.getRoles().remove(this);
        users.remove(user);
    }

    public List<NguoiNopThue> getUsers() {
        return users;
    }

    public void setUsers(List<NguoiNopThue> users) {
        this.users = users;
    }

    @Override
    public String getAuthority() {
        return this.name;
    }
}
