package fr.najet.bank.services;

import fr.najet.bank.entities.Account;
import fr.najet.bank.repositories.AccountRepository;
import fr.najet.bank.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    AccountRepository accountRepository;


    public List<Account> getAccounts(){
        return accountRepository.findAll();
    }

    public Account createAccount(Account account){
        return accountRepository.save(account);
    }

    public Optional <Account> getAccount(String id){return accountRepository.findById(id);}

    public void updateAccount( Account account) {accountRepository.save(account);}

    public void deleteAccountById(int id){ accountRepository.deleteById(id);}

}
