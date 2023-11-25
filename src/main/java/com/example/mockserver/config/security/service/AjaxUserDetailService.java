package com.example.mockserver.config.security.service;

import com.example.mockserver.user.entity.User;
import com.example.mockserver.user.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AjaxUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public AjaxUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
            .orElseThrow(() -> new UsernameNotFoundException("no such user"));
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("USER"));
        return new UserDetailsWithId(
            user.getUserId(),
            user.getEmail(),
            user.getPassword(),
            roles
        );
    }
}
