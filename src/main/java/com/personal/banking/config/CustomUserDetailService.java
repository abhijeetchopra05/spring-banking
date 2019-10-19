package com.personal.banking.config;

import com.personal.banking.domain.Role;
import com.personal.banking.domain.User;
import com.personal.banking.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> userOptional = userRepo.findByUserName(username);

        org.springframework.security.core.userdetails.User.UserBuilder userBuilder;

        if (userOptional.isPresent()) {

            User user = userOptional.get();
            userBuilder = org.springframework.security.core.userdetails.User.withUsername(username);
            userBuilder.password(passwordEncoder.encode(user.getPassword()));

            List<Role> roleList = new ArrayList<>(user.getRoleSet());
            String[] roles = new String[roleList.size()];
            for (int i = 0; i < roleList.size(); i++) {
                roles[i] = roleList.get(i).getName();
            }

            userBuilder.authorities(roles);
        } else {
            throw new UsernameNotFoundException("User does not exist");
        }

        return userBuilder.build();
    }
}
