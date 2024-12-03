package com.chaos_trials.api.domain.model.account;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(schema = "private", name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    private String username;

    private String email;

    private String password;

    @Column(name = "banned")
    private boolean ban;

    public UUID getUuid() {
        return uuid;
    }

    public boolean isBan() {
        return ban;
    }

    public void setBan(boolean ban) {
        this.ban = ban;
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

    public void setUsername(String username) {
        this.username = username;
    }
}

