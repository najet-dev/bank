package fr.najet.bank.services;

import fr.najet.bank.exception.AccountNotFoundException;
import fr.najet.bank.exception.BalanceNotSufficientException;
import fr.najet.bank.repositories.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class AccountOperationServiceTest {

  @Autowired
  AccountOperationService accountOperationService;

  @Autowired
  AccountRepository accountRepository;

  @Test
  void transfer() throws AccountNotFoundException, BalanceNotSufficientException {

    //compte A : 2000 euros
    //compte B : 100 euros
    // transfert de A vers B  500 euros




    // vérifier que A a 1500 euros
    // vérifier que B a 600 euros


  }

  @Test
  void transferSansSolde() {

    //compte A : 200 euros
    //compte B : 100 euros
    // transfert de 1 vers B  500 euros

    // vérifier que A a a toujours 200 euros
    // vérifier que B a toujours 100 euros
    // et si possible qu'une erreur est signalée
  }
}