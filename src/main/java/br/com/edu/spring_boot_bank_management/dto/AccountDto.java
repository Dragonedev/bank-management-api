package br.com.edu.spring_boot_bank_management.dto;

import br.com.edu.spring_boot_bank_management.database.model.AccountHolderEntity;
import br.com.edu.spring_boot_bank_management.database.model.enums.AccountType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    @NotNull(message = "Balance é obrigatório")
    private BigDecimal balance;
    @NotNull(message = "Tipo da conta é obrigatório")
    private AccountType accountType;
    @NotNull(message = "Id do Holder é obrigatório")
    private Integer accountHolderId;
}
