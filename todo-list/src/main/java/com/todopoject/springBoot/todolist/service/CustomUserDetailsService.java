package com.todopoject.springBoot.todolist.service;

import com.todopoject.springBoot.todolist.model.User;
import com.todopoject.springBoot.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);
        CustomUserDetails userDetails = null;
        if(user != null) {
            userDetails = new CustomUserDetails(user);
        }else{
            throw new UsernameNotFoundException("User not exist with name : " + username);
        }

        return userDetails;
    }
}
