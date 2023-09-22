package com.results.resultsDemo.service;

import com.results.resultsDemo.repositories.ResultSummaryRepository;
import org.springframework.stereotype.Service;

@Service
public class ResultSummaryService {

  private final ResultSummaryRepository resultSummaryRepository;

  public ResultSummaryService(ResultSummaryRepository resultSummaryRepository) {
    this.resultSummaryRepository = resultSummaryRepository;
  }

  public Integer getResultSummary(String system, String name, Integer from, Integer to) {
    return resultSummaryRepository.getResultSummaryValue(
        system, name, from, to);
  }
}
