package br.com.edu.spring_boot_bank_management.database.repository;

import br.com.edu.spring_boot_bank_management.database.model.AccountHolderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountHolderRepository extends JpaRepository<AccountHolderEntity, Integer> {
}
