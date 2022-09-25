package fr.najet.bank.repositories;

import fr.najet.bank.entities.AccountOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AccountOperationRepository extends JpaRepository <AccountOperation, Integer> {

    AccountOperation save(AccountOperation accountOperation);
    List<AccountOperation> findById(int id);
    @Query("FROM AccountOperation ur WHERE ur.createdAt = :createdAt")
    Page<AccountOperation> findByIdOrderBycreatedAtDesc(@Param("createdAt")int id, Pageable pageable);


}
