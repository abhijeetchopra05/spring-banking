package com.personal.banking.service.service_interface;

import com.personal.banking.dto.AccountDTO;

public interface AccountService {
    AccountDTO save(AccountDTO accountDTO);

    AccountDTO fetchByAccountNumber(Long accountNumber);

    AccountDTO update(Long accountNumber);
}
