package com.chaos_trials.api.application.form.login;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginForm {

    @Size(min = 4, message = "username deve possuir mais de 3 caracteres")
    @NotBlank(message = "username não pode ficar em branco")
    private String username;

    @NotBlank(message = "password não deve ficar em branco")
    private String password;

}
