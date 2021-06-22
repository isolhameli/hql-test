package com.example.demo.request;

public class UserUpdatePasswordRequest {

    private String password;
    private Long id;

    public UserUpdatePasswordRequest() {
    }

    public UserUpdatePasswordRequest(String password, Long id) {
        this.password = password;
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
