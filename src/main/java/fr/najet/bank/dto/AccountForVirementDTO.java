package fr.najet.bank.dto;

import fr.najet.bank.entities.Account;

public record AccountForVirementDTO(int id, String userName, String name) {

  public static AccountForVirementDTO fromAccount(Account a){
    return new AccountForVirementDTO(a.getId(), a.getUser().getFirstName() + " " + a.getUser().getLastName(), a.getName());
  }

}
