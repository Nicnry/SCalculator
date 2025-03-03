package com.crud.crud.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User extends BaseEntity<Long> {

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Salary> salaries;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    public User() {}

    public User(String name, String password, String email, List<Salary> salaries) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public User(Long userId) {
        this.setId(userId);
    }

    public List<Salary> getSalaries() {
        return salaries;
    }

    public void setSalaries(List<Salary> salaries) {
        this.salaries = salaries;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
