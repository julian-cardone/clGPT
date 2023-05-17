package com.jc.clGPT.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) { this.userRepository = userRepository; }

    public static <T> T getCurrentUser() {

        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            return (T) auth.getPrincipal();
        } catch(UsernameNotFoundException e) {
            return null;
        }

    }

    //new file


}
