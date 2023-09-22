package com.results.resultsDemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
public class ResultSummary {

  private String system;
  private String name;
  private Integer from;
  private Integer to;
  private Integer value;
}
