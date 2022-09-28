package fr.najet.bank.repositories;

import fr.najet.bank.entities.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJwtRepository extends JpaRepository<User, Long> {
  Optional<User> findById(Long id);
  Optional<User> findByUsername(String username);

  Boolean existsByUsername(String username);
  Boolean existsByEmail(String email);
}


