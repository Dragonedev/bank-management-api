package br.com.edu.spring_boot_bank_management.database.model;

import br.com.edu.spring_boot_bank_management.database.model.enums.AccountType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "account")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @OneToOne
    @JoinColumn(name = "account_holder_id")
    private AccountHolderEntity accountHolder;
}
