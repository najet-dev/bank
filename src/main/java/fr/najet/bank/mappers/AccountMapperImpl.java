package fr.najet.bank.mappers;

import fr.najet.bank.dto.AccountOperationDto;
import fr.najet.bank.entities.AccountOperation;
import org.springframework.beans.BeanUtils;

public class AccountMapperImpl {

    public AccountOperationDto fromAccountOperation(AccountOperation accountOperation) {
        AccountOperationDto accountOperationDto = new AccountOperationDto();
        BeanUtils.copyProperties(accountOperation, accountOperationDto);
        return accountOperationDto;
    }
}
