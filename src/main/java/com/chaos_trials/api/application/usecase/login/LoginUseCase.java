package com.chaos_trials.api.application.usecase.login;

import com.chaos_trials.api.application.dto.token_key.TokenKeyDTO;
import com.chaos_trials.api.application.form.login.LoginForm;
import com.chaos_trials.api.application.usecase.key_generation.KeyGeneration;
import com.chaos_trials.api.domain.model.account.Account;
import com.chaos_trials.api.domain.repository.account.AccountRepository;
import com.chaos_trials.api.util.jwt.JwtUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginUseCase {

    private final AccountRepository accountRepository;

    private final JwtUtil jwtUtil;

    private final KeyGeneration keyGeneration;

    public LoginUseCase(AccountRepository accountRepository,
                        JwtUtil jwtUtil,
                        KeyGeneration keyGeneration) {
        this.accountRepository = accountRepository;
        this.jwtUtil = jwtUtil;
        this.keyGeneration = keyGeneration;
    }

    public ResponseEntity<TokenKeyDTO> login(LoginForm loginForm) throws Exception {
        Optional<Account> optionalAccount = accountRepository.findFirstByEmailOrUsername(
                loginForm.getUsername()
        );
        if(optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            if(!account.isBan()) {
                Argon2 descriptografia = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
                if(descriptografia.verify(account.getPassword(),loginForm.getPassword())) {

                    return ResponseEntity.status(HttpStatus.ACCEPTED)
                            .body(new TokenKeyDTO(
                                    jwtUtil.generateToken(account.getEmail()),
                                    keyGeneration.generation(account.getUuid()))
                            );
                }
            }
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
