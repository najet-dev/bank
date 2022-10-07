package fr.najet.bank.controllers;

import fr.najet.bank.dto.AccountUserDto;
import fr.najet.bank.entities.Account;
import fr.najet.bank.entities.CurrentAccount;
import fr.najet.bank.entities.SavingsAccount;
import fr.najet.bank.entities.User;
import fr.najet.bank.exception.ApiRequestException;
import fr.najet.bank.repositories.AccountRepository;
import fr.najet.bank.repositories.CurrentAccountRepository;
import fr.najet.bank.repositories.SavingsAccountRepository;
import fr.najet.bank.repositories.UserRepository;
import fr.najet.bank.services.AccountService;
import fr.najet.bank.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin()
@RestController
public class AccountController {
  @Autowired
  UserRepository userRepository;

  @Autowired
  AccountRepository accountRepository;
  @Autowired
  AccountService accountService;
  @Autowired
  CurrentAccountRepository currentAccountRepository;

  @Autowired
  SavingsAccountRepository savingsAccountRepository;
  @Autowired
  UserService userService;


  /**
   * Read - Get all accounts
   *
   * @return -A List objet of account full filled
   */
  @GetMapping(value = "/accounts")
  public List<Account> getAccounts() {
    return accountService.getAccounts();
  }

  /**
   * Read - Get one account
   *
   * @param id The id of the account
   * @return An account object full filled
   */
  @GetMapping(value = "/account/{id}")
  public Account getAccountById(@PathVariable int id) {
    Account account = accountService.getAccount(id);
    if (account == null) {
      throw new ApiRequestException("Oops cannot get account with id " + id + " was not found");
    }
    return account;
  }

  /**
   * Create - create account
   *
   * @return -A List objet of account full filled
   */

  @PostMapping(value = "/account/add")
  public Account createAccount(@RequestBody AccountUserDto accountUserDto) throws Exception {
    Account createdAccount = null;
    User user = userService.getUser(accountUserDto.getUserId());
    if (accountUserDto.getType().equals("CurrentAccount")) {
      createdAccount = new CurrentAccount(accountUserDto.getBalance(), user,
          accountUserDto.getOverDraft());
      currentAccountRepository.save((CurrentAccount) createdAccount);
    } else if (accountUserDto.getType().equals("SavingsAccount")) {
      createdAccount = new SavingsAccount(accountUserDto.getBalance(), user,
          accountUserDto.getInterestRate());
      savingsAccountRepository.save((SavingsAccount) createdAccount);
    }
    return createdAccount;
  }

  /**
   * Modify - modify an account
   *
   * @return user - The account is updated
   */
  @PutMapping(value = "/account/update")
  @ResponseBody
  public Account updateAccount(@RequestBody Account account) {
    return this.accountService.updateAccount(account);
  }

  /**
   * Delete - Delete an account
   *
   * @param id - The id of the account to delete
   * @return account - An account is delete
   */
  @DeleteMapping("/accounts/{id}")
  @ResponseBody
  public ResponseEntity<Void> deleteAccountById(@PathVariable int id) throws Exception {
    accountService.deleteAccountById(id);
    return ResponseEntity.noContent().build();
  }

}












