package fr.najet.bank.entities;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserAccountSerializer extends JsonSerializer<List<Account>> {

  public void serialize(
      List<Account> accounts,
      JsonGenerator generator,
      SerializerProvider provider)
      throws IOException, JsonProcessingException {

    List<Integer> ids = new ArrayList<>();

    for (Account account : accounts) {
      ids.add(account.id);
    }

    generator.writeObject(ids);
  }

}


