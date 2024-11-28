package com.chaos_trials.api.application.form.register;

import com.chaos_trials.api.domain.model.account.Account;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
@Setter
public class RegisterForm {

    @Size(min = 4, message = "username deve possuir mais de 3 caracteres")
    @NotBlank(message = "username nao pode ser branca")
    private String username;

    @Size(min = 4, message = "email deve possuir mais de 3 caracteres")
    @Email(message = "email deve ser um email")
    @NotBlank(message = "email nao pode ser branca")
    private String email;

    @NotBlank(message = "password nao pode ser branca")
    private String password;

    public Account convertFormForAccount() {
        Account account = new Account();
        account.setUsername(this.getUsername());
        account.setPassword(this.getPassword());
        account.setEmail(this.getEmail());
        account.setBan(false);
        return account;
    }

}
