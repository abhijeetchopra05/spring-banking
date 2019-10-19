package com.personal.banking.service.service_interface;

import com.personal.banking.dto.UserDTO;

public interface UserService {

    UserDTO save(UserDTO userDTO);

    UserDTO fetch(String userId);

}
