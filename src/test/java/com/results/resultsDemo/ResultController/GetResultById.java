package com.results.resultsDemo.ResultController;


import com.results.resultsDemo.model.Result;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class GetResultById extends ResultControllerTest {

  @Test
  public void testGetById() throws Exception {
    Result result = new Result()
        .withId(1)
        .withSystem("Football")
        .withName("Olympic")
        .withDate(12345)
        .withValue(25);

    Mockito.when(resultService.getResultById(1))
        .thenReturn(result);

    ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/results/1"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content()
            .json("{"
                + "id: 1,"
                + "system: \"Football\","
                + "name: \"Olympic\","
                + "date: 12345,"
                + "value: 25"
                + "}")
        );

    Mockito.verify(resultService).getResultById(1);
  }

}
