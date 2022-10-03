package fr.najet.bank.services;

import fr.najet.bank.entities.Account;
import fr.najet.bank.repositories.AccountRepository;
import fr.najet.bank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountService {

  @Autowired
  AccountRepository accountRepository;

  @Autowired
  UserRepository userRepository;


  public List<Account> getAccounts() {
    return accountRepository.findAll();
  }

  public Account createAccount(Account account) {
    return accountRepository.save(account);
  }

  public Account getAccount(int id) {
    return accountRepository.findById(id);
  }

  public Account updateAccount(Account account) {
    return accountRepository.save(account);
  }

  public void deleteAccountById(int id) {
    accountRepository.deleteById(id);
  }

}


