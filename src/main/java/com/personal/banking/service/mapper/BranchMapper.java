package com.personal.banking.service.mapper;

import com.personal.banking.domain.Branch;
import com.personal.banking.dto.BranchDTO;
import org.springframework.stereotype.Component;


@Component
public class BranchMapper implements EntityMapper<BranchDTO, Branch> {
    @Override
    public BranchDTO toDto(Branch branch) {
        return null;
    }

    @Override
    public Branch toEntity(BranchDTO branchDTO) {
        return null;
    }
}
