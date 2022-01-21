package com.example.projectsoftuni.service.Impl;

import com.example.projectsoftuni.model.entity.User;
import com.example.projectsoftuni.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KvinsUserServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    public KvinsUserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user =
                userRepository.findByUsername(username).
                        orElseThrow(() -> new UsernameNotFoundException("Username with " + username + " not found"));
        return mapToUserDetails(user);
    }

    private static UserDetails mapToUserDetails(User userEntity){

        List<GrantedAuthority> authorities =
                userEntity.
                        getRoles().
                        stream().
                        map(r -> new SimpleGrantedAuthority("ROLE_" + r.getRole().name())).
                        collect(Collectors.toList());


        return new org.springframework.security.core.userdetails.User(
                userEntity.getUsername(),
                userEntity.getPassword(),
                authorities
        );
    }
}
