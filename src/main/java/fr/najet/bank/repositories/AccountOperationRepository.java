package fr.najet.bank.repositories;

import fr.najet.bank.entities.AccountOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AccountOperationRepository extends JpaRepository <AccountOperation, Long> {


   // AccountOperation findById(int id);
    AccountOperation save(AccountOperation accountOperation);
    List<AccountOperation> findById(int id);
}
