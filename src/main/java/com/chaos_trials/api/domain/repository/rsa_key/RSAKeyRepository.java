package com.chaos_trials.api.domain.repository.rsa_key;

import com.chaos_trials.api.domain.model.rsa_key.RSAKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RSAKeyRepository extends JpaRepository<RSAKey, UUID> {

}
