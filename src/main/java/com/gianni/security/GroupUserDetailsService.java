package com.gianni.security;

import com.gianni.Entities.User;
import com.gianni.Repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class GroupUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(repo.findByUsername(username));
        return user.map(GroupUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(username + " Not Found"));
    }
}