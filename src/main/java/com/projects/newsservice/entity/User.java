package com.projects.newsservice.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    @NotBlank(message = "Username can't be empty")
    private String username;
    @NotBlank(message = "Username can't be empty")
    private String password;
    private String role;
    @Email
    @NotBlank(message = "Email can't be empty")
    private String email;
    @Embedded
    private Audit audit = new Audit();

    public User() {
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long userId) {
        this.user_id = userId;
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
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
