package fr.najet.bank.repositories;

import fr.najet.bank.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findById(int id);
    User findByUserName(String userName);


}
