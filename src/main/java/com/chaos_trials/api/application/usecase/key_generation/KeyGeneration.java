package com.chaos_trials.api.application.usecase.key_generation;

import com.chaos_trials.api.domain.model.rsa_key.RSAKey;
import com.chaos_trials.api.domain.repository.rsa_key.RSAKeyRepository;
import com.chaos_trials.api.util.rsa.RSAUtil;
import org.springframework.stereotype.Service;

import java.security.KeyPair;
import java.util.Base64;
import java.util.UUID;

@Service
public class KeyGeneration {

    private final RSAKeyRepository rsaKeyRepository;

    public KeyGeneration(RSAKeyRepository rsaKeyRepository) {
        this.rsaKeyRepository = rsaKeyRepository;
    }

    public String generation(UUID uuid_account) {
        KeyPair keyPair = RSAUtil.generateKeyPair();

        RSAKey key = rsaKeyRepository.save(new RSAKey(uuid_account, keyPair.getPrivate().getEncoded()));

        return Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded());
    }

}
