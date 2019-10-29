package com.personal.banking.service.mapper;

import com.personal.banking.domain.CurrentAccount;
import com.personal.banking.dto.CurrentAccountDTO;
import org.springframework.stereotype.Component;


@Component
public class CurrentAccountMapper implements EntityMapper<CurrentAccountDTO, CurrentAccount> {
    @Override
    public CurrentAccountDTO toDto(CurrentAccount currentAccount) {
        return null;
    }

    @Override
    public CurrentAccount toEntity(CurrentAccountDTO currentAccountDTO) {
        return null;
    }
}
