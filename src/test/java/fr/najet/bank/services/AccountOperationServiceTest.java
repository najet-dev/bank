package fr.najet.bank.services;

import fr.najet.bank.dto.MessageDto;
import fr.najet.bank.dto.TransferDto;
import fr.najet.bank.exception.AccountNotFoundException;
import fr.najet.bank.exception.BalanceNotSufficientException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class AccountOperationServiceTest {

  @Autowired
  AccountOperationService accountOperationService;

  @Test
  void transfer() throws AccountNotFoundException, BalanceNotSufficientException {

    //compte A : 2000 euros
    //compte B : 100 euros
    // transfert de A vers B  500 euros
    TransferDto transferDto = new TransferDto();
    transferDto.setAccountSource(2);
    transferDto.setAccountDestination(3);
    transferDto.setAmount(500);

    MessageDto account = accountOperationService.transfer(2000, 100, 500);



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