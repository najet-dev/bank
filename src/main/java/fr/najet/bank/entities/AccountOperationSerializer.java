package fr.najet.bank.entities;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccountOperationSerializer extends JsonSerializer<List<AccountOperation>> {

    public void serialize(
            List<AccountOperation> accountOperations,
            JsonGenerator generator,
            SerializerProvider provider)
            throws IOException, JsonProcessingException {

        List<Integer> ids = new ArrayList<>();
        for (AccountOperation accountOperation : accountOperations) {
            ids.add(accountOperation.getId());
        }

        generator.writeObject(ids);
    }


}
