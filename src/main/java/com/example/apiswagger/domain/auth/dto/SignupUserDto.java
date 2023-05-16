package com.example.apiswagger.domain.auth.dto;

import com.example.apiswagger.domain.auth.Gender;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SignupUserDto {
    @NotBlank(message = "Name can't be empty")
    private String name;

    @Email(message = "Email not valid")
    private String email;

    @Min(value = 8,message = "Password must be at least 8 characters long")
    @NotBlank(message = "Password can't be empty")
    private String password;

    @Size(max = 200,message = "Age must be in range from 0 to 200")
    private int age;

    @NotNull(message = "Gender shouldn't be empty")
    private Gender gender;
}
