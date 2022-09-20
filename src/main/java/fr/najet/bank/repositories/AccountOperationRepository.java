package fr.najet.bank.repositories;

import fr.najet.bank.entities.AccountOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PaymentRepository extends JpaRepository <AccountOperation, Long> {

    List<AccountOperation> findByAccountId(String accountId);
    Page<AccountOperation> findByAccountIdOrderByOperationDateDesc(String accountId, Pageable pageable);
}
