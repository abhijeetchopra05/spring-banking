package com.personal.banking.service.mapper;


import com.personal.banking.domain.Role;
import com.personal.banking.domain.User;
import com.personal.banking.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserMapper implements EntityMapper<UserDTO, User> {


    @Override
    public UserDTO toDto(User user) {
        UserDTO userDTO = new UserDTO();
        List<String> roles = new ArrayList<>();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setUserName(user.getUserName());
        userDTO.setCreatedAt(user.getCreatedAt());
        userDTO.setUpdatedAt(user.getUpdatedAt());
        for (Role role : user.getRoleSet()) {
            roles.add(role.getName());
        }
        userDTO.setRole(roles);
        return userDTO;
    }

    @Override
    public User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPassword(userDTO.getPassword());
        if (userDTO.getId() != null) {
            user.setId(userDTO.getId());
        }
        user.setUserName(userDTO.getUserName());
        return user;
    }
}
