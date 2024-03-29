package com.personal.banking.controller;

import com.personal.banking.config.CustomUserDetailService;
import com.personal.banking.config.JwtTokenUtil;
import com.personal.banking.dto.LoginDTO;
import com.personal.banking.dto.TokenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        try {
            authenticate(loginDTO.getUserName(), loginDTO.getPassword());
            final UserDetails userDetails = customUserDetailService.loadUserByUsername(loginDTO.getUserName());
            final String token = jwtTokenUtil.generateToken(userDetails);
            TokenDTO tokenDTO = new TokenDTO();
            tokenDTO.setToken(token);
            return new ResponseEntity<>(tokenDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }


    private void authenticate(String userName, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
        } catch (Exception e) {
            throw new Exception("Wrong UserName and Password");
        }
    }
}
