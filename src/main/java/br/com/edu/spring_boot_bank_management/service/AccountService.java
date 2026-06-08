package br.com.edu.spring_boot_bank_management.service;

import br.com.edu.spring_boot_bank_management.database.model.AccountEntity;
import br.com.edu.spring_boot_bank_management.database.model.AccountHolderEntity;
import br.com.edu.spring_boot_bank_management.database.repository.IAccountHolderRepository;
import br.com.edu.spring_boot_bank_management.database.repository.IAccountRepository;
import br.com.edu.spring_boot_bank_management.dto.AccountDto;
import br.com.edu.spring_boot_bank_management.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final IAccountRepository accountRepository;
    private final IAccountHolderRepository accountHolderRepository;

    public void createAccount(AccountDto accountDto){

        AccountHolderEntity accountHolder = accountHolderRepository.findById(accountDto.getAccountHolderId())
                .orElseThrow(() ->  new NotFoundException("Holder não cadastrado"));

        AccountEntity account = AccountEntity.builder()
                .balance(accountDto.getBalance())
                .accountType(accountDto.getAccountType())
                .accountHolder(accountHolder)
        .build();

        accountRepository.save(account);
    }
}
