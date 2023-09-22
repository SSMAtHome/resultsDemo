package com.results.resultsDemo.ResultController;

import java.time.Instant;

import com.results.resultsDemo.controller.ResultController;
import com.results.resultsDemo.service.ResultService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ResultController.class)
public abstract class ResultControllerTest {

  @MockBean
  ResultService resultService;

  @Autowired
  MockMvc mockMvc;

  protected int getUnixTimeInteger(String date) {
    Long epochSecond = Instant.parse(date + "T00:00:00.00Z").getEpochSecond();
    return epochSecond.intValue();
  }


}