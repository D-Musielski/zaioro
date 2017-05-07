package com.zaioro.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Val on 2017-05-05.
 */

@Entity
public class User {

    private String username;

    private String password;

    private Boolean active = true;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    private List<Role> roles = new ArrayList<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role) {
        if(!this.roles.contains(role)) {
            this.roles.add(role);
        }

        if(!role.getUsers().contains(this)) {
            role.getUsers().add(this);
        }
    }

    public void removeRole(Role role) {
        this.roles.remove(role);
        role.getUsers().remove(this);
    }
}
