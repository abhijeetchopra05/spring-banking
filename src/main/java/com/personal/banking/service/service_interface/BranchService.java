package com.personal.banking.service.service_interface;

import com.personal.banking.dto.BranchDTO;

public interface BranchService {
    BranchDTO save(BranchDTO branchDTO);

    BranchDTO fetchById(Long id);

    BranchDTO update(Long id);
}
