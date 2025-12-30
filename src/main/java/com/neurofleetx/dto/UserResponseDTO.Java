package com.neurofleetx.dto;

import java.time.LocalDateTime;

public UserResponseDTO(String id, String name, String email, String role, String phone, LocalDateTime createdAt)

    public UserResponseDTO(String id, String name, String email, String role, String phone, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.phone = phone;
        this.createdAt = createdAt;
    }

    // Getters

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

