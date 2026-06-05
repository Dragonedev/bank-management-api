package br.com.edu.spring_boot_bank_management.dto;

import br.com.edu.spring_boot_bank_management.database.model.enums.AccountType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    private BigDecimal balance;
    private AccountType accountType;
}
