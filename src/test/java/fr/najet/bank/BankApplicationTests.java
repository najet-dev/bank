package fr.najet.bank;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.najet.bank.repositories.AccountOperationRepository;
import fr.najet.bank.services.AccountOperationService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(printOnlyOnFailure = false)
class BankApplicationTests {

  @Autowired
  AccountOperationRepository accountOperationRepository;
  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private AccountOperationService accountOperationService;

  private static ObjectMapper mapper = new ObjectMapper();

  @Test
  public void creditTest() throws Exception {
    mockMvc.perform(post("/credit")
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content("{\"id\":\"1\",\"description\":\"credit account 1\",\"amount\":20}")
            .accept(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isOk())
        .andDo(print());


  }
  @Test
  public void debitTest() throws Exception {
    mockMvc.perform(post("/debit")
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content("{\"id\":\"2\",\"description\":\"debit account 2\",\"amount\":45}")
            .accept(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isOk())
        .andDo(print());
  }
  @Test
  public void transferTest() throws Exception {
    mockMvc.perform(put("/transfer")
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content("{\"accountSource\":\"1\",\"accountDestination\":\"2\",\"amount\":-1003}")
            .accept(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isOk())
        .andDo(print());

  }

  }