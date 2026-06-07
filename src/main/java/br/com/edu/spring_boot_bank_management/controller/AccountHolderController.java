package br.com.edu.spring_boot_bank_management.controller;

import br.com.edu.spring_boot_bank_management.dto.AccountHolderDto;
import br.com.edu.spring_boot_bank_management.service.AccountHolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/account_holder")
public class AccountHolderController {

    private final AccountHolderService accountHolderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createAccountHolder(@RequestBody AccountHolderDto accountHolderDto){
        accountHolderService.createAccountHolder(accountHolderDto);
    }
}
