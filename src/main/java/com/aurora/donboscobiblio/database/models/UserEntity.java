package com.aurora.donboscobiblio.database.models;

import com.aurora.donboscobiblio.database.UserRolesService;

public class UserEntity {
    private Integer id;
    private String username;
    private String password;
    private String role;

    public UserEntity() {}

    public UserEntity(Integer id, String username, String role) {
        this.id = id;
        this.username = username;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getRole() {
        UserRolesService userRolesService = new UserRolesService();
        return userRolesService.getRoleById(this.id);
    }

    public void setRole(String role) {
        this.role = role;
    }
}
