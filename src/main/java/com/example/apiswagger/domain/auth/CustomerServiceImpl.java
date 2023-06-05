package com.example.apiswagger.domain.auth;

import com.example.apiswagger.domain.auth.dto.recieve.SignupUserDto;
import com.example.apiswagger.domain.web.dto.CustomExceptions;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepo;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public Customer addCustomer(@Valid SignupUserDto newCustomer) {
        if (customerRepo.existsByEmail(newCustomer.getEmail()))
            throw CustomExceptions.EntityWithExists("Email", newCustomer.getEmail()).get();
        Customer customer = modelMapper.map(newCustomer, Customer.class);

        return customerRepo.save(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepo.getCustomerById(id).orElseThrow(CustomExceptions.IdNotFound(Customer.class, id));
    }

    @Override
    public Customer getUserByEmail(String email) {
        return customerRepo.getCustomerByEmail(email).orElseThrow(CustomExceptions.PasswordOrLoginException());
    }


}
