package fr.najet.bank.controllers;

import fr.najet.bank.dto.CreditDto;
import fr.najet.bank.dto.DebitDto;
import fr.najet.bank.dto.TransferDto;
import fr.najet.bank.entities.AccountOperation;
import fr.najet.bank.exception.AccountNotFoundException;
import fr.najet.bank.exception.BalanceNotSufficientException;
import fr.najet.bank.repositories.AccountOperationRepository;
import fr.najet.bank.repositories.AccountRepository;
import fr.najet.bank.services.AccountOperationService;
import fr.najet.bank.services.AccountService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
  public DebitDto debit(@RequestBody DebitDto debitDto)
      throws AccountNotFoundException, BalanceNotSufficientException {
    accountOperationService.debit(debitDto.getId(), debitDto.getAmount(),
        debitDto.getDescription());
    return debitDto;
  }

  @PostMapping("/credit")
  @ResponseBody
  public CreditDto credit(@RequestBody CreditDto creditDto)
      throws AccountNotFoundException, BalanceNotSufficientException {
    accountOperationService.credit(creditDto.getId(), creditDto.getAmount(),
        creditDto.getDescription());
    return creditDto;
  }

  @PutMapping("/transfer")
  public void transfer(@RequestBody TransferDto transferDto)
      throws AccountNotFoundException, BalanceNotSufficientException {
    accountOperationService.transfer(transferDto.getAccountSource(),
        transferDto.getAccountDestination(),
        transferDto.getAmount());
  }
   /* @GetMapping("/operations/{id}")
    public List<AccountOperationDto> getHistorical(@PathVariable int id){
        return accountOperationService.historical(id);
    }*/


  @GetMapping("/{accountId}/pageOperations")
  public Page<AccountOperation> getAccountHistorical(
      @PathVariable int accountId,
      @RequestParam(name = "page", defaultValue = "0") int page,
      @RequestParam(name = "size", defaultValue = "3") int size) throws AccountNotFoundException {

    return accountOperationService.getAccountHistorical(accountId, page, size);
  }


}