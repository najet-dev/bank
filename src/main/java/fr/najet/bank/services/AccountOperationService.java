package fr.najet.bank.services;

import fr.najet.bank.entities.AccountOperation;
import fr.najet.bank.repositories.AccountOperationRepository;
import fr.najet.bank.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountOperationService{

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountOperationRepository accountOperationRepository;


    public List<AccountOperation> getAccountOperations(){
        return accountOperationRepository.findAll();
    }

    public AccountOperation createAccountOperation(AccountOperation accountOperation){
        return accountOperationRepository.save(accountOperation);
    }

   /*public void transfer(int codeSource, int codeDestination, double amount) {
        Account account1 = accountRepository.findById(codeSource);
        Account account2 = accountRepository.findById(codeDestination);
        account1.setBalance(account1.getBalance() - amount);

        account2.setBalance(account2.getBalance() + amount);
        accountRepository.save(account1);
        accountRepository.save(account2);
    }*/

   /*public void debit(int accountId, double amount, String description) throws AccountNotFoundException, BalanceNotSufficientException {

        Account account = accountRepository.findById(accountId);

        if(account == null){
            throw new AccountNotFoundException("Account not found");
        }
        else if(account.getBalance()<amount) {
            throw new BalanceNotSufficientException("Balance not sufficient");
        }

        AccountOperation accountOperation = new AccountOperation();
        accountOperation.setType(OperationTypeEnum.DEBIT);
        accountOperation.setAmount(amount);
        accountOperation.setOperationDate(new Date());
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
        accountOperation.setOperationDate(new Date());
        accountOperation.setAccount(account);
        accountOperation.setDescription(description);

        accountOperationRepository.save(accountOperation);

        account.setBalance(account.getBalance()-amount);
        accountRepository.save(account);
    }
    public void transfer(int accountSource, int accountDestination, double amount) throws AccountNotFoundException, BalanceNotSufficientException {
        debit(accountSource, amount, "Transfer to "+accountDestination);
        credit(accountDestination, amount, "Transfer from "+accountSource);
    }*/



}
