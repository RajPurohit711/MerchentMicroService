package com.example.SpringAuthentication.Service;

import com.example.SpringAuthentication.Entity.User;
import com.example.SpringAuthentication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUserName(username);
        if(user == null)
        {
            throw new UsernameNotFoundException("user name not found");
        }


        return new com.example.SpringAuthentication.Details.UserDetails(user);
    }
}
