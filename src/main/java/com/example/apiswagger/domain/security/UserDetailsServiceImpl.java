package com.example.apiswagger.domain.security;

import com.example.apiswagger.domain.auth.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UserDetailsServiceImpl implements UserDetailsService {

    private final CustomerRepository customerRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Override
    public UserDetails loadUserByUsername(String ID) throws UsernameNotFoundException {
        logger.info("LoadUserByUsername: ID = "+ID);
        return UserDetailsImpl.build(
                customerRepository.getCustomerById(Long.valueOf(ID))
                        .orElseThrow(() -> new UsernameNotFoundException("User with ID " + ID + " not found")));

    }
}
