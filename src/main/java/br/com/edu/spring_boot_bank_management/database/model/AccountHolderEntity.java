package br.com.edu.spring_boot_bank_management.database.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "account_holder")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AccountHolderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String CPF;

}
