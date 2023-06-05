package com.example.apiswagger.domain.auth;

import com.example.apiswagger.domain.auth.dto.recieve.RefreshTokenDto;
import com.example.apiswagger.domain.auth.dto.recieve.SigninUserDto;
import com.example.apiswagger.domain.auth.dto.recieve.SignupUserDto;
import com.example.apiswagger.domain.security.JwtTokenRepository;
import com.example.apiswagger.domain.web.dto.CustomExceptions;
import com.example.apiswagger.domain.web.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final CustomerService customerService;
    private final JwtTokenRepository jwtRepo;
    private final PasswordEncoder passwordEncoder;

    private final Long accessTokenLifetime = 5L;
    private final Long refreshTokenLifetime = 60L;


    @PostMapping("auth/signup")
    private ResponseEntity signUp(@RequestBody SignupUserDto newCustomer) {
        newCustomer.setPassword(passwordEncoder.encode(newCustomer.getPassword()));
        Customer customer = customerService.addCustomer(newCustomer);

        return ResponseEntity.ok(jwtRepo.generateJwtPair(customer.getId(), refreshTokenLifetime, accessTokenLifetime));
    }

    @PostMapping("auth/signout")
    private ResponseEntity signOut() {
        return ResponseEntity.ok(new MessageDto("NOT OK"));
    }

    @PostMapping("auth/signin")
    private ResponseEntity signIn(@RequestBody SigninUserDto user) {
        Customer customer = customerService.getUserByEmail(user.getEmail());

        if (! passwordEncoder.matches(user.getPassword(), customer.getPassword()))
            throw CustomExceptions.PasswordOrLoginException().get();

        return ResponseEntity.ok(jwtRepo.generateJwtPair(customer.getId(), refreshTokenLifetime, accessTokenLifetime));
    }

    @PostMapping("auth/refresh")
    private ResponseEntity refresh(@RequestBody RefreshTokenDto token) {
        Customer customer = customerService.getCustomerById(jwtRepo.getCustomerID(token.getRefreshToken()));
        return ResponseEntity.ok(jwtRepo.generateJwtPair(customer.getId(), refreshTokenLifetime, accessTokenLifetime));
    }
}
