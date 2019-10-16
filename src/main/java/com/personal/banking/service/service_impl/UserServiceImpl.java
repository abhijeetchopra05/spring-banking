package com.personal.banking.service.service_impl;

import com.personal.banking.domain.User;
import com.personal.banking.dto.UserDTO;
import com.personal.banking.repo.UserRepo;
import com.personal.banking.service.mapper.UserMapper;
import com.personal.banking.service.service_interface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepo userRepo;

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDTO save(UserDTO userDTO) {

        Optional<User> user = userRepo.findById(userDTO.getId());

        if (user.isPresent()) {
            // return a custom exception
        }

        return userMapper.toDto(userRepo.save(userMapper.toEntity(userDTO)));
    }
}
