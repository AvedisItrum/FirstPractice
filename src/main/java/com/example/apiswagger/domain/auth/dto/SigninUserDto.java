package com.example.apiswagger.domain.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SigninUserDto {
    @Email(message = "Email not valid")
    private String email;

    @Min(value = 8,message = "Password must be at least 8 characters long")
    @NotBlank(message = "Password can't be empty")
    private String password;
}
