package br.com.edu.spring_boot_bank_management.service;

import br.com.edu.spring_boot_bank_management.database.model.AccountEntity;
import br.com.edu.spring_boot_bank_management.database.repository.IAccountRepository;
import br.com.edu.spring_boot_bank_management.dto.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final IAccountRepository accountRepository;

    public void createAccount(AccountDto accountDto){
        AccountEntity account = AccountEntity.builder()
                .balance(accountDto.getBalance())
                .accountType(accountDto.getAccountType())
        .build();

        accountRepository.save(account);
    }
}
