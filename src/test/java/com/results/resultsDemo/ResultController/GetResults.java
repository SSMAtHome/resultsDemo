package com.results.resultsDemo.ResultController;

import com.results.resultsDemo.model.Result;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class GetResults extends ResultControllerTest{

    @Test
    public void testGetResults() throws Exception {
        List<Result> results = new ArrayList<>() {
            {

                add(new Result().withId(1).withSystem("Football").withName("Olympic").withDate(12345).withValue(25));
                add(new Result().withId(2).withSystem("Football").withName("Olympic").withDate(12346).withValue(30));
            }
        };

        // Mock the service to return the sample results
        Mockito.when(resultService.getResults(Mockito.anyString(),
                        Mockito.anyString(),
                        Mockito.anyInt(),
                        Mockito.anyInt()))
                .thenReturn(results);

        // Perform the GET request to the API
        ResultActions resultActions = mockMvc.
                perform(MockMvcRequestBuilders.get("/results")
                .param("system", "Football")
                .param("name", "Olympic")
                .param("from", "12300")
                .param("to", "12400")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray()) // Expecting a JSON array

                .andExpect(MockMvcResultMatchers.content().json(
                        "["
                        + "{"
                        + "id: 1,"
                        + "system: \"Football\","
                        + "name: \"Olympic\","
                        + "date: 12345,"
                        + "value: 25"
                        + "},"
                        + "{"
                        + "id: 2,"
                        + "system: \"Football\","
                        + "name: \"Olympic\","
                        + "date: 12346,"
                        + "value: 30"
                        + "}"
                        + "]"
                ));
        Mockito.verify(resultService).getResults("Football", "Olympic", 12300, 12400);
    }
}
