package com.personal.banking.controller;


import com.personal.banking.dto.BranchDTO;
import com.personal.banking.service.service_interface.BranchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BranchController {

    private final BranchService branchService;

    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @PostMapping("/branch")
    public ResponseEntity<BranchDTO> save(BranchDTO branchDTO) {
        return new ResponseEntity<>(branchService.save(branchDTO), HttpStatus.CREATED);
    }

    @GetMapping("/branch/{id}")
    public ResponseEntity<BranchDTO> fetchById(Long id)
    {
        return new ResponseEntity<>(branchService.fetchById(id),HttpStatus.OK);
    }

    @PutMapping("/branch/{id}")
    public ResponseEntity<BranchDTO> update(Long id) {
        return new ResponseEntity<>(branchService.update(id),HttpStatus.ACCEPTED);
    }
}
