package fr.najet.bank.repositories;

import fr.najet.bank.entities.Account;
import fr.najet.bank.enums.AccountTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, String> {
    Account findById(int id);
    void deleteById(int id);
    @Query("SELECT a FROM Account a WHERE type = :type")
    List<Account> findByType(@Param(value="type") AccountTypeEnum accountTypeEnum);
}
