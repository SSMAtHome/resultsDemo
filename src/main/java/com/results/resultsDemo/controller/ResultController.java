package com.results.resultsDemo.controller;

import com.results.resultsDemo.model.Result;
import com.results.resultsDemo.service.ResultService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@AllArgsConstructor
@RestController
public class ResultController {

  private ResultService resultService;

  @GetMapping("/")
  public List<Result> getListOfResults() {
    return resultService.getListOfAllResults();
  }

  // http://localhost:8080/results?system=Olympic&name=football&from=1687707742&to=1687707753
  @GetMapping("/results")
  public List<Result> getResults(@RequestParam String system,
                                 @RequestParam(required = false) String name,
                                 @RequestParam(required = false) Integer from,
                                 @RequestParam(required = false) Integer to) {
    if (system == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
    return resultService.getResults(system, name, from, to);
  }

  @GetMapping("/results/{id}")
  public Result getResultById(@PathVariable Integer id) {
    return resultService.getResultById(id);
  }

  @PostMapping("/results")
  public void createResult(@RequestBody Result result) {
    if (result.getSystem() == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
    if (result.getName() == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
    resultService.createResult(result);
  }

  @PutMapping("/results")
  public void updateResult(@RequestBody Result updatedResult) {
    if (updatedResult.getSystem() == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
    if (updatedResult.getName() == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
    if (updatedResult.getDate() == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
    Result oldResult = resultService.getResultBySystemAndNameAndDate(
        updatedResult.getSystem(), updatedResult.getName(), updatedResult.getDate());

    if (oldResult == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    resultService.updateResult(oldResult, updatedResult);
  }

}
