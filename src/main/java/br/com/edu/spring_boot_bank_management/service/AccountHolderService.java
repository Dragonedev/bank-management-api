package br.com.edu.spring_boot_bank_management.service;

import br.com.edu.spring_boot_bank_management.database.model.AccountHolderEntity;
import br.com.edu.spring_boot_bank_management.database.repository.IAccountHolderRepository;
import br.com.edu.spring_boot_bank_management.dto.AccountHolderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountHolderService {

    private final IAccountHolderRepository accountHolderRepository;

    public void createAccountHolder(AccountHolderDto accountHolderDto){
        AccountHolderEntity accountHolder = AccountHolderEntity.builder().
                name(accountHolderDto.getName())
                .CPF(accountHolderDto.getCPF())
                .build();

        accountHolderRepository.save(accountHolder);
    }
}
