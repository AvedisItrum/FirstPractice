package com.example.apiswagger.domain.auth;

import com.example.apiswagger.domain.auth.dto.recieve.SignupUserDto;


public interface CustomerService {
    //Create
    Customer addCustomer(SignupUserDto user);

    //Read
    Customer getCustomerById(Long id);
    Customer getUserByEmail(String email);
    //Update

    //Delete

}
