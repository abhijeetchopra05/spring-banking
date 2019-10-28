package com.personal.banking.service.service_impl;

import com.personal.banking.dto.AccountDTO;
import com.personal.banking.service.service_interface.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Override
    public AccountDTO save(AccountDTO accountDTO) {
        return null;
    }

    @Override
    public AccountDTO fetchByAccountNumber(Long accountNumber) {
        return null;
    }

    @Override
    public AccountDTO update(Long accountNumber) {
        return null;
    }
}
