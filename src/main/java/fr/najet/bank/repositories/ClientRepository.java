package fr.najet.bank.repositories;

import fr.najet.bank.entities.Account;
import fr.najet.bank.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findById(int id);


}
