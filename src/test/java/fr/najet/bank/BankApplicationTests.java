package fr.najet.bank;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.najet.bank.repositories.AccountOperationRepository;
import fr.najet.bank.services.AccountOperationService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class BankApplicationTests {

  @Autowired
  AccountOperationRepository accountOperationRepository;
  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private AccountOperationService accountOperationService;

  private static ObjectMapper mapper = new ObjectMapper();


  @Test
  public void transferTest() throws Exception {
    String json = '{' +
                   "'accountSource': 2," +
                    "'accountDestination':3,"+
                    "'amount':50" +
                  '}';

    mockMvc.perform(
            put("/transfer/").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(jsonPath("$.accountSource", Matchers.equalTo(2)))
        .andExpect(jsonPath("$.accountDestination", Matchers.equalTo(3)))
        .andExpect(jsonPath("$.amount", Matchers.equalTo(50)))
        .andDo(print());

  }

}