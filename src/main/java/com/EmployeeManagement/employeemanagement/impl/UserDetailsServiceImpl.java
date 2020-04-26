package com.EmployeeManagement.employeemanagement.impl;

import com.EmployeeManagement.employeemanagement.entity.UserEntity;
import com.EmployeeManagement.employeemanagement.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByuserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username of password !");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),
                Arrays.asList(new SimpleGrantedAuthority("USER")));
    }
}
