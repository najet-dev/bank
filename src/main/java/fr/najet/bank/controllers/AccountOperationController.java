package fr.najet.bank.controllers;

import fr.najet.bank.dto.AccountHistoryDto;
import fr.najet.bank.dto.CreditDto;
import fr.najet.bank.dto.DebitDto;
import fr.najet.bank.dto.TransferDto;
import fr.najet.bank.entities.AccountOperation;
import fr.najet.bank.exception.AccountNotFoundException;
import fr.najet.bank.exception.ApiRequestException;
import fr.najet.bank.exception.BalanceNotSufficientException;
import fr.najet.bank.repositories.AccountOperationRepository;
import fr.najet.bank.repositories.AccountRepository;
import fr.najet.bank.services.AccountOperationService;
import fr.najet.bank.services.AccountService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin()
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
  /**
   * Read - Get one accountOperation
   *
   * @param id The id of the accountOperation
   * @return An account object full filled
   */
  @GetMapping(value = "/accountOperation/{id}")
  public AccountOperation getAccountOperationById(@PathVariable int id) {
    AccountOperation accountOperation = accountOperationService.getAccountOperation(id);
    if (accountOperation == null) {
      throw new ApiRequestException("Oops cannot get account with id " + id + " was not found");
    }
    return accountOperation;
  }
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

  @DeleteMapping("/accountOperation/{id}")
  @ResponseBody
  public ResponseEntity<Void> deleteAccountOpearationById(@PathVariable int id) throws Exception {
    accountOperationService.deleteAccountOperationById(id);
    return ResponseEntity.noContent().build();
  }
  @GetMapping("/{accountId}/pageOperations")
  public AccountHistoryDto getAccountHistorical(
      @PathVariable int accountId,
      @RequestParam(name = "page", defaultValue = "0") int page,
      @RequestParam(name = "size", defaultValue = "3") int size) throws AccountNotFoundException {

    return accountOperationService.getAccountHistorical(accountId, page, size);
  }


}