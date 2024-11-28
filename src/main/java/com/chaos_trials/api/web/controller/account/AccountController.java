package com.chaos_trials.api.web.controller.account;

import com.chaos_trials.api.application.form.login.LoginForm;
import com.chaos_trials.api.application.form.register.RegisterForm;
import com.chaos_trials.api.application.usecase.login.LoginUseCase;
import com.chaos_trials.api.application.usecase.register.RegisterUseCase;
import com.chaos_trials.api.domain.model.account.Account;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AccountController {

    private final LoginUseCase loginUseCase;

    private final RegisterUseCase registerUseCase;

    public AccountController(LoginUseCase loginUseCase,
                             RegisterUseCase registerUseCase) {
        this.loginUseCase = loginUseCase;
        this.registerUseCase = registerUseCase;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginForm loginForm) {
        return loginUseCase.login(loginForm);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid RegisterForm registerForm) {
        return registerUseCase.register(registerForm);
    }
}

