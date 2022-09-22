package fr.najet.bank.controllers;

import fr.najet.bank.dto.AccountDto;
import fr.najet.bank.dto.SavingsAccountDto;
import fr.najet.bank.entities.Account;
import fr.najet.bank.entities.CurrentAccount;
import fr.najet.bank.entities.SavingsAccount;
import fr.najet.bank.exception.ApiRequestException;
import fr.najet.bank.repositories.AccountRepository;
import fr.najet.bank.repositories.CurrentAccountRepository;
import fr.najet.bank.repositories.SavingsAccountRepository;
import fr.najet.bank.repositories.UserRepository;
import fr.najet.bank.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Account getAccountById(@PathVariable int id){
        Account account = accountService.getAccount(id) ;
        if(account == null) throw new ApiRequestException("Oops cannot get account with id "+ id  + " was not found");
        return account;
    }

    /**
     * Create - create account
     *
     * @return -A List objet of account full filled
     */
    @PostMapping(value = "/account/add")
    public Account createAccount(@RequestBody AccountDto accountDto) throws Exception{

        if(accountDto.getType().equals("CurrentAccount")){
            CurrentAccount currentAccount = new Account(accountDto.getId(), accountDto.getType(), accountDto.getCreatedAt(), accountDto.getBalance(), accountDto.getUser(),accountDto.getLastName(), accountDto.getFirstName(),accountDto.getEmail(), accountDto.getUserName(), accountDto.getRole(), accountDto.getPassword(), accountDto.getAccountOperations(), accountDto.getOverDraft(), accountDto.getInterestRate());
            currentAccountRepository.save (currentAccount);
            return Account;
        }else if(accountDto.getType().equals("SavingsAccount")) {
            SavingsAccount savingsAccount = new  SavingsAccountDto(accountDto.getType(), accountDto.getCreatedAt(), accountDto.getBalance(), accountDto.getUser(), accountDto.getAccountOperations(), accountDto.getInterestRate());
            savingsAccountRepository.save(savingsAccount);
            return Account;
        }
        return null;
    }

    /**
     * Modify - modify a account
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
    public ResponseEntity<Void> deleteAccountById(@PathVariable int id) throws Exception{
        accountService.deleteAccountById(id);
        return ResponseEntity.noContent().build();
    }

}












