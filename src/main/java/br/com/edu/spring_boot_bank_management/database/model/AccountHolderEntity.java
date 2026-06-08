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
    @Column(name = "account_holder_id")
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String CPF;

    @OneToOne(mappedBy = "accountHolder", cascade = CascadeType.ALL, orphanRemoval = true)
    private ContactsEntity contact;

}
