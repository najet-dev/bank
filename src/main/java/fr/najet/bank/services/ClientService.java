package fr.najet.bank.services;

import fr.najet.bank.entities.Client;
import fr.najet.bank.entities.User;
import fr.najet.bank.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;


    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    public User createUser(Client client){
        return clientRepository.save(client);
    }

    public User getClient(int id){return clientRepository.findById(id);}

    public void updateClient( Client client) {clientRepository.save(client);}

    public void deleteClientById(int id){ clientRepository.deleteById(id);}

}
