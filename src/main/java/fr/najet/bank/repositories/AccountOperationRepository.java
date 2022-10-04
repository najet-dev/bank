package fr.najet.bank.repositories;

import fr.najet.bank.entities.AccountOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountOperationRepository extends JpaRepository<AccountOperation, Integer> {

  AccountOperation save(AccountOperation accountOperation);

  AccountOperation findById(int id);
 // List<AccountOperation> findByAccountId(int id);

 Page<AccountOperation> findByAccountIdOrderByCreatedAtDesc(int accountId,
                                                            Pageable pageable);




}
