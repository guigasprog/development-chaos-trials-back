package com.chaos_trials.api.application.usecase.register;

import com.chaos_trials.api.application.form.register.RegisterForm;
import com.chaos_trials.api.domain.model.account.Account;
import com.chaos_trials.api.domain.repository.account.AccountRepository;
import com.chaos_trials.api.util.jwt.JwtUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterUseCase {

    private final AccountRepository accountRepository;

    private final JwtUtil jwtUtil;

    private final PasswordEncoder passwordEncoder;

    public RegisterUseCase(AccountRepository accountRepository, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    public ResponseEntity<String> register(RegisterForm registerForm) {
        Optional<Account> optionalAccount = accountRepository.findFirstByEmailOrUsername(
                registerForm.getEmail(), registerForm.getUsername()
        );
        if(optionalAccount.isEmpty()) {

            registerForm.setPassword(generateHash(registerForm.getPassword()));

            Account account = accountRepository.save(registerForm.convertFormForAccount());

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(jwtUtil.generateToken(account.getEmail()));
        }
        return ResponseEntity.status(HttpStatus.FOUND).build();
    }

    private static String generateHash(String password) {
        Argon2 criptografia = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        return criptografia.hash(4, 1024 * 1024, 8, password);
    }

}
