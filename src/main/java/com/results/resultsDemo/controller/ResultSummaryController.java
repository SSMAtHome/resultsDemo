package com.results.resultsDemo.controller;

import com.results.resultsDemo.service.ResultSummaryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@AllArgsConstructor
@RestController
public class ResultSummaryController {

  ResultSummaryService resultSummaryService;

  // http://localhost:8080/resultsummary?system=Olympic&name=football&from=1687707742&to=1687707753
  @GetMapping("/resultsummary")
  public Integer getResults(
      @RequestParam String system,
      @RequestParam(required = false) String name,
      @RequestParam(required = false) Integer from,
      @RequestParam(required = false) Integer to) {
    if (system == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
    return resultSummaryService.getResultSummary(system, name, from, to);
  }
}
