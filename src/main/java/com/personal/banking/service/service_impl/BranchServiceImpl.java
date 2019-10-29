package com.personal.banking.service.service_impl;

import com.personal.banking.domain.Branch;
import com.personal.banking.dto.BranchDTO;
import com.personal.banking.repo.BranchRepo;
import com.personal.banking.service.mapper.BranchMapper;
import com.personal.banking.service.service_interface.BranchService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class BranchServiceImpl implements BranchService {

    private final BranchMapper branchMapper;

    private final BranchRepo branchRepo;

    public BranchServiceImpl(BranchMapper branchMapper, BranchRepo branchRepo) {
        this.branchMapper = branchMapper;
        this.branchRepo = branchRepo;
    }


    @Override
    public BranchDTO save(BranchDTO branchDTO) {
        return branchMapper.toDto(save(branchMapper.toEntity(branchDTO)));
    }

    @Override
    public BranchDTO fetchById(Long id) {
        return null;
    }

    @Override
    public BranchDTO update(Long id) {
        return null;
    }


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    Branch save(Branch branch) {
        return branchRepo.save(branch);
    }
}
