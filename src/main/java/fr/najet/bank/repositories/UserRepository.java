package fr.najet.bank.repositories;

import fr.najet.bank.entities.User;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
  Optional<User> findById(UUID id);

  Optional<User> findByUsername(String username);

  Boolean existsByUsername(String username);


 

}
