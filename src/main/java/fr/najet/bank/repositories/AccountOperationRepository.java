package fr.najet.bank.repositories;

import fr.najet.bank.entities.AccountOperation;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountOperationRepository extends JpaRepository<AccountOperation, Integer> {

  AccountOperation save(AccountOperation accountOperation);

  List<AccountOperation> findById(int id);

   /* @Query(value = "SELECT `amount` FROM account_operation WHERE account_id=:x", nativeQuery = true)
    public List<AccountOperation> getAccountOperations(@Param("x") int code, Pageable pageable);*/

 Page<AccountOperation> findByAccountIdOrderByCreatedAtDesc(int accountId,
                                                                Pageable pageable);




}
