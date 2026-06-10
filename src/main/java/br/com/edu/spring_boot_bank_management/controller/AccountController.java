package br.com.edu.spring_boot_bank_management.controller;

import br.com.edu.spring_boot_bank_management.dto.AccountDto;
import br.com.edu.spring_boot_bank_management.exception.NotFoundException;
import br.com.edu.spring_boot_bank_management.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/account")
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createAccount(@Valid @RequestBody AccountDto accountDto){
        accountService.createAccount(accountDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAccountHolder(@PathVariable Integer id){
        accountService.deleteAccount(id);
    }
}
