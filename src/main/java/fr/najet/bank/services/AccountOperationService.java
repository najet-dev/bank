package fr.najet.bank.services;

import fr.najet.bank.dto.AccountHistoryDto;
import fr.najet.bank.dto.AccountOperationDto;
import fr.najet.bank.entities.Account;
import fr.najet.bank.entities.AccountOperation;
import fr.najet.bank.enums.OperationTypeEnum;
import fr.najet.bank.exception.AccountNotFoundException;
import fr.najet.bank.exception.BalanceNotSufficientException;
import fr.najet.bank.mappers.AccountMapperImpl;
import fr.najet.bank.repositories.AccountOperationRepository;
import fr.najet.bank.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AccountOperationService{

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountOperationRepository accountOperationRepository;
    private AccountMapperImpl dtoMapper;





    public List<AccountOperation> getAccountOperations(){
        return accountOperationRepository.findAll();
    }

   /* public AccountOperation createAccountOperation(AccountOperation accountOperation){
        return accountOperationRepository.save(accountOperation);
    }*/

    public void debit(int id, double amount, String description) throws AccountNotFoundException, BalanceNotSufficientException {

        Account account = accountRepository.findById(id);

        if(account == null){
            throw new AccountNotFoundException("Account not found");
        }
        else if(account.getBalance()<amount) {
            throw new BalanceNotSufficientException("Balance not sufficient");
        }

        AccountOperation accountOperation = new AccountOperation();
        accountOperation.setType(OperationTypeEnum.DEBIT);
        accountOperation.setAmount(amount);
        accountOperation.setCreatedAt(new Date());
        accountOperation.setAccount(account);
        accountOperation.setDescription(description);

        accountOperationRepository.save(accountOperation);

        account.setBalance(account.getBalance()-amount);
        accountRepository.save(account);
    }
    public void credit(int accountId, double amount, String description) throws AccountNotFoundException, BalanceNotSufficientException {

        Account account = accountRepository.findById(accountId);

        if(account == null){
            throw new AccountNotFoundException("Account not found");
        }
        else if(account.getBalance()<amount) {
            throw new BalanceNotSufficientException("Balance not sufficient");
        }

        AccountOperation accountOperation = new AccountOperation();
        accountOperation.setType(OperationTypeEnum.CREDIT);
        accountOperation.setAmount(amount);
        accountOperation.setCreatedAt(new Date());
        accountOperation.setAccount(account);
        accountOperation.setDescription(description);

        accountOperationRepository.save(accountOperation);

        account.setBalance(account.getBalance()+amount);
        accountRepository.save(account);
    }
    public void transfer(int accountSource, int accountDestination, double amount) throws AccountNotFoundException, BalanceNotSufficientException {
        debit(accountSource, amount, "Transfer to "+accountDestination);
        credit(accountDestination, amount, "Transfer from "+accountSource);
    }



    public List<AccountOperationDto> historical(int id) {
        List<AccountOperation> accountOperations = accountOperationRepository.findById(id);
        return accountOperations.stream()
                .map(op -> dtoMapper.fromAccountOperation(op))
                .collect(Collectors.toList());
    }
    public AccountHistoryDto getAccountHistorical(int id, int page, int size) throws AccountNotFoundException {

        Account account = accountRepository.findById(id);
        if(account==null) {
            throw new AccountNotFoundException("Bank Account Not Found");
        }
        Page<AccountOperation> accountOperations = accountOperationRepository.findByIdOrderBycreatedAtDesc(id, PageRequest.of(page, size));
        AccountHistoryDto accountHistoryDto= new AccountHistoryDto();
        List<AccountOperationDto> accountOperationDtos = accountOperations.getContent().stream().map(op -> dtoMapper.fromAccountOperation(op)).collect(Collectors.toList());
        accountHistoryDto.setAccountOperationDtos(accountOperationDtos);
        accountHistoryDto.setId (account.getId());
        accountHistoryDto.setBalance(account.getBalance());
        accountHistoryDto.setPageSize (size);
        accountHistoryDto.setCurrentPage(page);
        accountHistoryDto.setTotalPages(accountOperations.getTotalPages());
        return accountHistoryDto;
    }





}
