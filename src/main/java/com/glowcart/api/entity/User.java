package com.glowcart.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String mobile;

    // ✅ REQUIRED by Hibernate
    public User() {
    }

    public User(Long id, String name, String mobile) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
    }

    // ✅ getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }
}
