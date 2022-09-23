package fr.najet.bank.services;

import fr.najet.bank.entities.Account;
import fr.najet.bank.entities.AccountOperation;
import fr.najet.bank.enums.OperationTypeEnum;
import fr.najet.bank.exception.AccountNotFoundException;
import fr.najet.bank.exception.BalanceNotSufficientException;
import fr.najet.bank.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public void transfer(int codeSource, int codeDestination, double amount) {
        Account account1 = accountRepository.findById(codeSource);
        Account account2 = accountRepository.findById(codeDestination);
        account1.setBalance(account1.getBalance() - amount);

        account2.setBalance(account2.getBalance() + amount);
        accountRepository.save(account1);
        accountRepository.save(account2);
    }

}

