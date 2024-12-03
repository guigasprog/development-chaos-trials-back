package com.chaos_trials.api.web.controller.account;

import com.chaos_trials.api.application.dto.token_key.TokenKeyDTO;
import com.chaos_trials.api.application.form.login.LoginForm;
import com.chaos_trials.api.application.form.register.RegisterForm;
import com.chaos_trials.api.application.usecase.login.LoginUseCase;
import com.chaos_trials.api.application.usecase.register.RegisterUseCase;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<TokenKeyDTO> login(@RequestBody @Valid LoginForm loginForm) throws Exception {
        return loginUseCase.login(loginForm);
    }

    @PostMapping("/register")
    public ResponseEntity<TokenKeyDTO> register(@RequestBody @Valid RegisterForm registerForm) throws Exception {
        return registerUseCase.register(registerForm);
    }

    @GetMapping("/teste")
    public ResponseEntity<String> teste() {
        return ResponseEntity.ok("TESTEEEE");
    }


}

