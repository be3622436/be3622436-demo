package com.example.kracedemo.entity.mysql;

public class UserRole extends User {
    private Role role;

    public Role getRole() {
        return role;
    }
    public void setRole(Role newRole) {
        role = newRole;
    }
}
