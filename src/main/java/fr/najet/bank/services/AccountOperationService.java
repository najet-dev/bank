package fr.najet.bank.services;

import fr.najet.bank.dto.AccountHistoryDto;
import fr.najet.bank.dto.AccountOperationDto;
import fr.najet.bank.dto.MessageDto;
import fr.najet.bank.entities.Account;
import fr.najet.bank.entities.AccountOperation;
import fr.najet.bank.enums.OperationTypeEnum;
import fr.najet.bank.exception.AccountNotFoundException;
import fr.najet.bank.exception.BalanceNotSufficientException;
import fr.najet.bank.repositories.AccountOperationRepository;
import fr.najet.bank.repositories.AccountRepository;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AccountOperationService {

  @Autowired
  AccountRepository accountRepository;

  @Autowired
  AccountService accountService;
  @Autowired
  AccountOperationRepository accountOperationRepository;

  public List<AccountOperation> getAccountOperations() {
    return accountOperationRepository.findAll();
  }


   /* public AccountOperation createAccountOperation(AccountOperation accountOperation){
        return accountOperationRepository.save(accountOperation);
    }*/

  public void debit(int id, double amount, String description)
      throws AccountNotFoundException, BalanceNotSufficientException {

    Account account = accountRepository.findById(id);

    if (account == null) {
      throw new AccountNotFoundException("Account not found");
    } else if (account.getBalance() < amount) {
      throw new BalanceNotSufficientException("Balance not sufficient");
    }

    AccountOperation accountOperation = new AccountOperation();
    accountOperation.setType(OperationTypeEnum.DEBIT);
    accountOperation.setAmount(amount);
    accountOperation.setCreatedAt(new Date());
    accountOperation.setAccount(account);
    accountOperation.setDescription(description);

    accountOperationRepository.save(accountOperation);

    account.setBalance(account.getBalance() - amount);
    accountRepository.save(account);
  }

  public void credit(int accountId, double amount, String description)
      throws AccountNotFoundException, BalanceNotSufficientException {

    Account account = accountRepository.findById(accountId);

    if (account == null) {
      throw new AccountNotFoundException("Account not found");
    } else if (account.getBalance() < amount) {
      throw new BalanceNotSufficientException("Balance not sufficient");
    }

    AccountOperation accountOperation = new AccountOperation();
    accountOperation.setType(OperationTypeEnum.CREDIT);
    accountOperation.setAmount(amount);
    accountOperation.setCreatedAt(new Date());
    accountOperation.setAccount(account);
    accountOperation.setDescription(description);

    accountOperationRepository.save(accountOperation);

    account.setBalance(account.getBalance() + amount);
    accountRepository.save(account);
  }

  public MessageDto transfer(int accountSource, int accountDestination, double amount)
      throws AccountNotFoundException, BalanceNotSufficientException {
    Account account = accountRepository.findById(accountSource);
    if (Objects.isNull(account)) {
      throw new AccountNotFoundException("le compte suivant n'existe pas" + accountSource);
    }
    double accountAmount = account.getBalance();
    //System.out.println(amount <= accountAmount);
    if (amount <= accountAmount) {
      debit(accountSource, amount, "Transfer to " + accountDestination);
      credit(accountDestination, amount, "Transfer from " + accountSource);
      return new MessageDto("virement effectué");
    } else {
      throw new BalanceNotSufficientException("Le montant est supérieur à la balance du compte");
    }
  }

  public AccountOperation getAccountOperation(int id) {
    return accountOperationRepository.findById(id);
  }

  public void deleteAccountOperationById(int id) {
    accountOperationRepository.deleteById(id);
  }

  public AccountHistoryDto getAccountHistorical(int accountId, int page, int size)
      throws AccountNotFoundException {

    Account account = accountRepository.findById(accountId);

    if (account == null) {
      throw new AccountNotFoundException("Bank Account Not Found");
    }

    Page<AccountOperation> accountOperations =
        accountOperationRepository.findByAccountIdOrderByCreatedAtDesc(accountId,
            PageRequest.of(page, size));

    Page<AccountOperationDto> pagedDto = accountOperations.map(
        AccountOperationDto::fromAccountOperation
    );
    AccountHistoryDto accountHistoryDto = new AccountHistoryDto();
    accountHistoryDto.setAccountId(account.getId());
    accountHistoryDto.setBalance(account.getBalance());
    accountHistoryDto.setPageSize(size);
    accountHistoryDto.setCurrentPage(page);
    accountHistoryDto.setAccountOperationsDto(pagedDto);
    return accountHistoryDto;
  }


}
