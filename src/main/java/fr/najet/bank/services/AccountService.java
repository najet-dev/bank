package fr.najet.bank.services;

import fr.najet.bank.entities.Account;
import fr.najet.bank.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public Account createAccount(Account account){
        final Account acounts= accountRepository.save(account);
        return acounts;
    }


}
