package fr.najet.bank.controllers;

import fr.najet.bank.dto.AccountDto;
import fr.najet.bank.entities.Account;
import fr.najet.bank.repositories.AccountRepository;
import fr.najet.bank.repositories.UserRepository;
import fr.najet.bank.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class AccountController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    AccountService accountService;

    /**
     * Create - create a account
     * @return -A List objet of account full filled
     */
    @PostMapping(value = "/account/add")
    @ResponseBody
    public Account addAccount(@RequestBody AccountDto accountDto) {
        Account account = new Account(accountDto.getId(), accountDto.getCreatedAt(), accountDto.getBalance(), accountDto.getUser(), accountDto.getPayments());
        return this.accountService.createAccount(account);
    }









}
