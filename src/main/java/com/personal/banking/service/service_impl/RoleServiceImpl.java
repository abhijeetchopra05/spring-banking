package com.personal.banking.service.service_impl;

import com.personal.banking.domain.Role;
import com.personal.banking.exception.RoleDoesNotExistException;
import com.personal.banking.repo.RoleRepo;
import com.personal.banking.service.service_interface.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {


    private final RoleRepo roleRepo;

    public RoleServiceImpl(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public Role getRoleByName(String name) {
        return roleRepo.findByName(name).orElseThrow(RoleDoesNotExistException::new);
    }
}
