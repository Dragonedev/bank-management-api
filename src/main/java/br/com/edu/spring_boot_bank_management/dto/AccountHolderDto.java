package br.com.edu.spring_boot_bank_management.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountHolderDto {

    private String name;
    private String CPF;

    private ContactsDto contact;
}
