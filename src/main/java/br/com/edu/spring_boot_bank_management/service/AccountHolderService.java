package br.com.edu.spring_boot_bank_management.service;

import br.com.edu.spring_boot_bank_management.database.model.AccountEntity;
import br.com.edu.spring_boot_bank_management.database.model.AccountHolderEntity;
import br.com.edu.spring_boot_bank_management.database.model.ContactsEntity;
import br.com.edu.spring_boot_bank_management.database.repository.IAccountHolderRepository;
import br.com.edu.spring_boot_bank_management.database.repository.IAccountRepository;
import br.com.edu.spring_boot_bank_management.database.repository.IContactsRepository;
import br.com.edu.spring_boot_bank_management.dto.AccountHolderDto;
import br.com.edu.spring_boot_bank_management.exception.BadRequestException;
import br.com.edu.spring_boot_bank_management.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountHolderService {

    private final IAccountHolderRepository accountHolderRepository;
    private final IAccountRepository accountRepository;
    private final IContactsRepository contactsRepository;

    @Transactional
    public void createAccountHolder(AccountHolderDto accountHolderDto){

        if (accountHolderDto.getContact() == null){
            throw new BadRequestException("Contact is required");
        }

        AccountHolderEntity accountHolder = AccountHolderEntity.builder()
                .name(accountHolderDto.getName())
                .CPF(accountHolderDto.getCPF())
                .build();

        accountHolder = accountHolderRepository.save(accountHolder);

        ContactsEntity contact = ContactsEntity.builder()
                .email(accountHolderDto.getContact().getEmail())
                .phoneNumber(accountHolderDto.getContact().getPhoneNumber())
                .accountHolder(accountHolder)
                .build();

        accountHolder.setContact(contact);

        contactsRepository.save(contact);
    }

    @Transactional
    public void deleteAccountHolder(Integer accountHolderId){
        AccountHolderEntity accountHolder = accountHolderRepository.findById(accountHolderId)
                .orElseThrow(()-> new NotFoundException("Holder not found"));

        if(!accountHolder.getAccounts().isEmpty()){
            throw new BadRequestException("Cannot delete account holder because there are associated acccounts");
        }

        accountHolderRepository.delete(accountHolder);
    }
}
