package fr.najet.bank.repositories;

import fr.najet.bank.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account, String> {
    Account findById(int id);
    void deleteById(int id);
    @Query("SELECT a FROM Account a WHERE type = :type")
    Account findByType(String type);
}
