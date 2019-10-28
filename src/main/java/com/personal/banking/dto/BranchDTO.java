package com.personal.banking.dto;

import com.personal.banking.domain.Account;

import java.util.List;

public class BranchDTO {

    private Long id;

    private String name;

    private Long branchCode;

    private List<Long> accountNumbers;
}
