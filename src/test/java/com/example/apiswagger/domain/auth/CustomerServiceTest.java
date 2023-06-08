package com.example.apiswagger.domain.auth;

import com.example.apiswagger.domain.auth.dto.recieve.SignupUserDto;
import jakarta.persistence.EntityExistsException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Test
    void addCustomer() {
        Customer customer = customerService.addCustomer(new SignupUserDto("Name", "email@email.ru", "password", 29, Gender.MALE));
        assertEquals(customer.getName(), "Name");
    }

    @Test
    void alreadyExist() {
        assertThrows(EntityExistsException.class, () -> customerService.addCustomer(new SignupUserDto("Name", "email@email.ru", "password", 29, Gender.MALE)));
    }

    @Test
    void getCustomerById() {
    }

    @Test
    void getUserByEmail() {
    }
}