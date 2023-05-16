package com.example.apiswagger.domain.auth;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name can't be empty")
    private String name;

    @Email(message = "Email not valid")
    private String email;

    @Min(value = 8,message = "Password must be at least 8 characters long")
    @NotBlank(message = "Password can't be empty")
    private String password;

    @Size(max = 200,message = "Age must be in range from 0 to 200")
    private int age = 0;

    @NotNull(message = "Gender shouldn't be empty")
    private Gender gender;
}
