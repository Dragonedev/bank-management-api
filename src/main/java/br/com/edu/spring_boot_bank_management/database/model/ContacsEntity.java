package br.com.edu.spring_boot_bank_management.database.model;

import jakarta.persistence.*;

@Table(name = "contacts")
public class ContacsEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;
    private String phoneNumber;

    @JoinColumn(name = "account_holder_id")
    private AccountHolderEntity accountHolder;
}
