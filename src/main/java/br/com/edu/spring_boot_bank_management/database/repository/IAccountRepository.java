package br.com.edu.spring_boot_bank_management.database.repository;

import br.com.edu.spring_boot_bank_management.database.model.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends JpaRepository<AccountEntity, Integer> {

}
