package com.example.bookstore.configuration;

public class AuthRequest {
    private String username;
    private String password;

    // ✅ Make sure these are present
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
}
