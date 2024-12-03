package com.chaos_trials.api.domain.model.rsa_key;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@Entity
@Table(schema = "private", name = "rsa_keys")
public class RSAKey {

    @Id
    private UUID uuid_account;

    private byte[] private_key;

    private LocalDateTime created_at;

    public RSAKey(UUID uuid_account, byte[] private_key) {
        this.uuid_account = uuid_account;
        this.private_key = private_key;
        this.created_at = LocalDateTime.now();
    }

    public byte[] getPrivateKey() {
        return private_key;
    }
}
