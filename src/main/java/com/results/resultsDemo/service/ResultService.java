package com.results.resultsDemo.service;

import com.results.resultsDemo.model.Result;
import com.results.resultsDemo.repositories.ResultRepository;
import java.time.Instant;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ResultService {

  private final ResultRepository resultRepository;

  public ResultService(ResultRepository resultRepository) {
    this.resultRepository = resultRepository;
  }

  public List<Result> getListOfAllResults() {
    return resultRepository.findAll();
  }

  public List<Result> getResults(String system, String name, Integer fromDate, Integer toDate) {
    return resultRepository.getResultsGroupBySystemFromDateToDate(system, name, fromDate, toDate);
  }

  public Result getResultById(Integer id) {
    return resultRepository.findById(id).orElse(null);
  }

  public void createResult(Result result) {
    if (result.getValue() == null) {
      result.setValue(1);
    }
    if (result.getDate() == null) {
      Long epochSecond = Instant.now().getEpochSecond();
      result.setDate(epochSecond.intValue());
    }
    resultRepository.save(result);
  }

  public void updateResult(Result oldResult, Result newResult) {
    if (newResult.getValue() == null) {
      oldResult.setValue(oldResult.getValue() + 1);
    } else {
      oldResult.setValue(newResult.getValue());
    }
    resultRepository.save(oldResult);
  }

  public Result getResultBySystemAndNameAndDate(String system, String name, Integer date) {
    return resultRepository.getResultBySystemAndNameAndDate(system, name, date);
  }
}
