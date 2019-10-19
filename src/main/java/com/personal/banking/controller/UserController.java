package com.personal.banking.controller;


import com.personal.banking.dto.UserDTO;
import com.personal.banking.service.service_interface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/save")
    public ResponseEntity<UserDTO> save(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.save(userDTO), HttpStatus.CREATED);
    }


    @GetMapping("/fetch/{userName}")
    public ResponseEntity<UserDTO> fetchUserWithId(@PathVariable("userName") String userName) {
        return new ResponseEntity<>(userService.fetch(userName),HttpStatus.OK);
    }
}
