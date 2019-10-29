package com.personal.banking.service.service_impl;

import com.personal.banking.domain.Role;
import com.personal.banking.domain.User;
import com.personal.banking.dto.UserDTO;
import com.personal.banking.exception.UserAlreadyExistException;
import com.personal.banking.repo.UserRepo;
import com.personal.banking.service.mapper.UserMapper;
import com.personal.banking.service.service_interface.RoleService;
import com.personal.banking.service.service_interface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepo userRepo;

    @Autowired
    UserMapper userMapper;

    @Autowired
    RoleService roleService;


    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDTO save(UserDTO userDTO) {
        Optional<User> user = userRepo.findByUserName(userDTO.getUserName());
        if (user.isPresent()) {
            throw new UserAlreadyExistException();
        }

        User newUser = userMapper.toEntity(userDTO);
        Set<Role> roles = new HashSet<>();
        for (String s : userDTO.getRole()) {
            roles.add(roleService.getRoleByName(s));
        }
        newUser.setRoleSet(roles);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        newUser = save(newUser);
        return userMapper.toDto(newUser);
    }

    @Override
    public UserDTO fetch(String userName) {
        Optional<User> user = userRepo.findByUserName(userName);
        // throw exception of user does not exist
        return user.map(value -> userMapper.toDto(value)).orElse(null);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
        // so that commit is done and then the result is returned.
    User save(User user) {
        return userRepo.save(user);
    }

}
