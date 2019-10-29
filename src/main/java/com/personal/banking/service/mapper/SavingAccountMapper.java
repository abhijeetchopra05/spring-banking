package com.personal.banking.service.mapper;

import com.personal.banking.domain.SavingAccount;
import com.personal.banking.dto.SavingAccountDTO;
import org.springframework.stereotype.Component;


@Component
public class SavingAccountMapper implements EntityMapper<SavingAccountDTO, SavingAccount> {
    @Override
    public SavingAccountDTO toDto(SavingAccount savingAccount) {
        return null;
    }

    @Override
    public SavingAccount toEntity(SavingAccountDTO savingAccountDTO) {
        return null;
    }
}
