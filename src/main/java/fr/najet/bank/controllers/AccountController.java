package fr.najet.bank.controllers;

import fr.najet.bank.entities.Account;
import fr.najet.bank.repositories.AccountRepository;
import fr.najet.bank.repositories.ClientRepository;
import fr.najet.bank.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class AccountController {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ClientService clientService;

    /**
     * Create - create a account
     * @return -A List objet of account full filled
     */
    @PostMapping(value = "/accounts/add")
    @ResponseBody
    public List<Account> createAccount(@RequestBody Account accountDto) throws Exception{
        try{
            accountRepository.save(accountDto);
            List<Account> accounts = accountRepository.findAll();
            return  accounts;
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }


}
