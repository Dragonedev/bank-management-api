package br.com.edu.spring_boot_bank_management.service;

import br.com.edu.spring_boot_bank_management.database.model.AccountHolderEntity;
import br.com.edu.spring_boot_bank_management.database.model.ContactsEntity;
import br.com.edu.spring_boot_bank_management.database.repository.IAccountHolderRepository;
import br.com.edu.spring_boot_bank_management.database.repository.IContactsRepository;
import br.com.edu.spring_boot_bank_management.dto.AccountHolderDto;
import br.com.edu.spring_boot_bank_management.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountHolderService {

    private final IAccountHolderRepository accountHolderRepository;
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
}
