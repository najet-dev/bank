package fr.najet.bank.repositories;

import fr.najet.bank.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findById(int id);
    Account save(Account account);

    // Account getById(String id);

    void deleteById(int id);

}
