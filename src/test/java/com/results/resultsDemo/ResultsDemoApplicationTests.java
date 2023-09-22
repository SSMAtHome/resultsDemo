package com.results.resultsDemo;

import com.results.resultsDemo.model.Result;
import com.results.resultsDemo.repositories.ResultRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ResultsDemoApplicationTests {

/*  @Autowired
  ResultSummaryDao resultSummaryDao;*/

  @Autowired
  ResultRepository resultRepository;


  @Test
  void contextLoads() {
    Result resultOne = new Result( "Olympic", "football", 3, 3);
    Result resultTwo = new Result( "Olympic", "football", 4, 5);
    Result resultThree = new Result( "Olympic", "footabll", 5, 8);

    resultRepository.save(resultOne);
    resultRepository.save(resultTwo);
    resultRepository.save(resultThree);


  }

}
