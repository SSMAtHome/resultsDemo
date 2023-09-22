package com.results.resultsDemo.ResultController;

import java.util.ArrayList;
import java.util.List;

import com.results.resultsDemo.model.Result;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class GetResultsInRange extends ResultControllerTest {

  @Test
  public void testGetResults() throws Exception {

    String system = "Olympic";
    String name = "Football";

    Integer from = getUnixTimeInteger("2023-01-01");
    Integer to = getUnixTimeInteger("2023-01-10");
    List<Result> results = new ArrayList<>() {
      {

        add(new Result()
            .withId(1)
            .withSystem(system)
            .withName(name)
            .withDate(from)
            .withValue(25));
        add(new Result()
            .withId(2)
            .withSystem(system)
            .withName(name)
            .withDate(getUnixTimeInteger("2023-01-05"))
            .withValue(35));
      }
    };

    Mockito.when(resultService.getResults(system,
            name,
            from,
            to))
        .thenReturn(results);

    ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get(
            "/results")
                            .param("system","Olympic")
                            .param("name","Football")
                            .param("from",from.toString())
                            .param("to",to.toString())
            )
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content()
            .json("["
                + "{"
                + "id: 1,"
                + "system: \"Olympic\","
                + "name: \"Football\","
                + "date: " + from.toString() + ","
                + "value: 25"
                + "},"
                + "{"
                + "id: 2,"
                + "system: \"Olympic\","
                + "name: \"Football\","
                + "date: " + getUnixTimeInteger("2023-01-05") + ","
                + "value: 35"
                + "}"
                + "]")
        );

    Mockito.verify(resultService).getResults(system, name, from,
        to);
  }

}
