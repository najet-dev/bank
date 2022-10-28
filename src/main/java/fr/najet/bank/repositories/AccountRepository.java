package fr.najet.bank.repositories;

import fr.najet.bank.entities.Account;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
  Account findById(int id);
  Account save(Account account);

//  @Query("SELECT t FROM Tutorial t WHERE t.published=?1")

  List<Account> findByUser_Id(int idUser);

  void deleteById(int id);

}
