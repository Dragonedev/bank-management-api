package br.com.edu.spring_boot_bank_management.database.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "contacts")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "account_holder_id")
    private AccountHolderEntity accountHolder;
}
