package fr.najet.bank.controllers;

import fr.najet.bank.entities.AccountOperation;
import fr.najet.bank.repositories.AccountOperationRepository;
import fr.najet.bank.repositories.AccountRepository;
import fr.najet.bank.services.AccountOperationService;
import fr.najet.bank.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountOperationController {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    AccountOperationService accountOperationService;
    @Autowired
    AccountOperationRepository accountOperationRepository;
    @Autowired
    AccountService accountService;
    /**
     * Read - Get all accounts
     *
     * @return -A List objet of account full filled
     */
    @GetMapping(value = "/accountOperations")
    public List<AccountOperation> getAccountOperations() {
        return accountOperationService.getAccountOperations();
    }



   /* @PostMapping(value = "/account/add")
    public Account createAccount(@RequestBody AccountOperationDto accountOperationDto) throws Exception {

     return null;
    }*/

    /*@PutMapping(value="transfer")
    public void transfer(@RequestBody TransferDto request){
        accountOperationService.transfer(request.getAccountSource(),request.getAccountDestination(),request.getAmount());
    }*/
  /*  @PostMapping("/debit")
    @ResponseBody
    public DebitDto debit(@RequestBody DebitDto debitDto) throws AccountNotFoundException, BalanceNotSufficientException {
        accountOperationService.debit (debitDto.getAccountId(), debitDto.getAmount(), debitDto.getDescription());
        return debitDto;
    }

    @PostMapping("/credit")
    @ResponseBody
    public CreditDto credit(@RequestBody CreditDto creditDto) throws AccountNotFoundException, BalanceNotSufficientException {
        accountOperationService.credit (creditDto.getAccountId(), creditDto.getAmount(), creditDto.getDescription());
        return creditDto;
    }
    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferDto transferDto) throws AccountNotFoundException, BalanceNotSufficientException {
        accountOperationService.transfer(transferDto.getAccountSource(),
                transferDto.getAccountDestination(),
                transferDto.getAmount());
    }*/
}