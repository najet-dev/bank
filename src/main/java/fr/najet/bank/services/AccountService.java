package fr.najet.bank.services;

import fr.najet.bank.entities.Account;
import fr.najet.bank.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;


    public List<Account> getAccounts(){
        return accountRepository.findAll();
    }

    public Account createAccount(Account account){
        return accountRepository.save(account);
    }

    public  Account getAccount(int id){return accountRepository.findById(id);}

    public Account updateAccount( Account account) {return accountRepository.save(account);}


    public void deleteAccountById(int id){ accountRepository.deleteById(id);}

}

