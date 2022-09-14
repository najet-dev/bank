package fr.najet.bank.controllers;

import fr.najet.bank.dto.ClientDto;
import fr.najet.bank.entities.Account;
import fr.najet.bank.entities.Client;
import fr.najet.bank.entities.User;
import fr.najet.bank.exception.ApiRequestException;
import fr.najet.bank.repositories.AccountRepository;
import fr.najet.bank.repositories.ClientRepository;
import fr.najet.bank.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ClientService clientService;

    /**
     * Create - create a client
     * @return -A List objet of client full filled
     */
    @PostMapping(value = "/clients/add")
    @ResponseBody
    public List<Client> createClient(@RequestBody Client clientDto) throws Exception{
        try{
            clientRepository.save(clientDto);
            List<Client> clients = clientRepository.findAll();
            return  clients;
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }
    @PostMapping(value = "/client/add/{idAccount}/client/{idAccount}")
    @ResponseBody
    public Account addAccounToClient(@PathVariable int idClient, @PathVariable int idAccount)
            throws Exception {

        try {
            Account account = accountRepository.findById(idAccount);
            Client client = clientRepository.findById(idClient);
            if (account.getClient() == null) {
                account.setClient(client);
                accountRepository.save(account);
                return account;
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }


    /**
     * Read - Get all clients
     * @return -A List objet of client full filled
     */
    @GetMapping(value="/clients")
    public List<Client> getClients(){
        return clientService.getClients();
    }

    /**
     * Read - Get one client
     * @param id The id of the client
     * @return A user object full filled
     */
    @GetMapping(path = "/clients/{id}")
    public User getClientById(@PathVariable(value="id") int id){
        User user = clientService.getClient(id) ;
        if(user == null) throw new ApiRequestException("Oops cannot get client with id "+ id  + " was not found");
        return this.clientService.getClient(id);
    }
    /**
     * Modify - modify a client
     * @return user - The client is updated
     */
    @PutMapping("/clients")
    @ResponseBody
    public List<Client> updateClient(@RequestBody ClientDto clientDto)throws Exception{
        try{
            Client client = ClientDto.addClient(clientDto);
            clientService.updateClient(client);
            List<Client> clients = clientService.getClients();
            return  clients;
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }
    /**
     * Delete - Delete a client
     * @param id - The id of the client to delete
     * @return client - The client is deleted
     */
    @DeleteMapping("/clients/{id}")
    @ResponseBody
    public ResponseEntity<Void> deleteClientById(@PathVariable int id) throws Exception{
        clientService.deleteClientById(id);
        return ResponseEntity.noContent().build();
    }


}
