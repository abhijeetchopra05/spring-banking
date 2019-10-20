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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody LoginDTO loginDTO) {
        authenticate(loginDTO.getUserName(), loginDTO.getPassword());
        final UserDetails userDetails = customUserDetailService.loadUserByUsername(loginDTO.getUserName());
        final String token = jwtTokenUtil.generateToken(userDetails);
        TokenDTO tokenDTO = new TokenDTO();
        tokenDTO.setToken(token);
        return new ResponseEntity<>(tokenDTO, HttpStatus.OK);

    }


    private void authenticate(String userName, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
        } catch (Exception e) {

        }
    }
}
