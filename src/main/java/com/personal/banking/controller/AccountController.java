package com.personal.banking.controller;

import com.personal.banking.domain.Account;
import com.personal.banking.domain.SavingAccount;
import com.personal.banking.dto.AccountDTO;
import com.personal.banking.dto.SavingAccountDTO;
import com.personal.banking.service.service_interface.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/account")
    public ResponseEntity<AccountDTO> save(@RequestBody AccountDTO accountDTO) {
        return new ResponseEntity<>(accountService.save(accountDTO), HttpStatus.CREATED);
    }

    @GetMapping("/account/{accountNumber}")
    public ResponseEntity<AccountDTO> fetchByAccountNumber(@PathVariable Long accountNumber) {
        return new ResponseEntity<>(accountService.fetchByAccountNumber(accountNumber), HttpStatus.OK);
    }

    @PutMapping("/account/{accountNumber}")
    public ResponseEntity<AccountDTO> update(@PathVariable Long accountNumber) {
        return new ResponseEntity<>(accountService.update(accountNumber), HttpStatus.ACCEPTED);
    }
}
