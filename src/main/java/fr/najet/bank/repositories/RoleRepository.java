package fr.najet.bank.repositories;

import fr.najet.bank.entities.Role;
import fr.najet.bank.enums.ERole;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
  Optional<Role> findByName(ERole name);
}

