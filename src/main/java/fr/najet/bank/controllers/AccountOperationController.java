package fr.najet.bank.controllers;

import fr.najet.bank.dto.*;
import fr.najet.bank.entities.AccountOperation;
import fr.najet.bank.exception.AccountNotFoundException;
import fr.najet.bank.exception.BalanceNotSufficientException;
import fr.najet.bank.repositories.AccountOperationRepository;
import fr.najet.bank.repositories.AccountRepository;
import fr.najet.bank.services.AccountOperationService;
import fr.najet.bank.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

   /* @PutMapping(value="transfer")
    public void transfer(@RequestBody TransferDto transfer){
        accountService.transfer(transfer.getAccountSource(),transfer.getAccountDestination(), transfer.getAmount());
    }*/
      @PostMapping("/debit")
    @ResponseBody
    public DebitDto debit(@RequestBody DebitDto debitDto) throws AccountNotFoundException, BalanceNotSufficientException {
        accountOperationService.debit (debitDto.getId(), debitDto.getAmount(), debitDto.getDescription());
        return debitDto;
    }

    @PostMapping("/credit")
    @ResponseBody
    public CreditDto credit(@RequestBody CreditDto creditDto) throws AccountNotFoundException, BalanceNotSufficientException {
        accountOperationService.credit (creditDto.getId(), creditDto.getAmount(), creditDto.getDescription());
        return creditDto;
    }
    @PutMapping("/transfer")
    public void transfer(@RequestBody TransferDto transferDto) throws AccountNotFoundException, BalanceNotSufficientException {
        accountOperationService.transfer(transferDto.getAccountSource(),
                transferDto.getAccountDestination(),
                transferDto.getAmount());
    }
    @GetMapping("/operations/{id}")
    public List<AccountOperationDto> getHistorical(@PathVariable int id){
        return accountOperationService.historical(id);
    }


    @GetMapping("/{id}/pageOperations")
    public AccountHistoryDto getAccountHistorical(
            @PathVariable int id,
            @RequestParam(name ="page", defaultValue = "0") int page,
            @RequestParam(name ="size", defaultValue = "5") int size) throws AccountNotFoundException{

        return accountOperationService.getAccountHistorical(id, page, size);
    }




}