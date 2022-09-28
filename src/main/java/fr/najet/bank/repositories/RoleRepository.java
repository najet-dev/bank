package fr.najet.bank.repositories;

import fr.najet.bank.entities.Role;
import fr.najet.bank.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(ERole name);
}

