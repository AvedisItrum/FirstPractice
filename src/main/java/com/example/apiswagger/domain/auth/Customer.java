package com.example.apiswagger.domain.auth;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name = "customers",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name can't be empty")
    private String name;

    @Email(message = "Email not valid")
    private String email;

    @Size(min = 8,message = "Password must be at least 8 characters long")
    @NotBlank(message = "Password can't be empty")
    private String password;

    @Max( value= 200,message = "Age must be less than 200")
    @Min( value= 0,message = "Age must be greater than 0")
    private int age;

    @NotNull(message = "Gender shouldn't be empty")
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
