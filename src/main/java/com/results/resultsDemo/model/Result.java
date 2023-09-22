package com.results.resultsDemo.model;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.With;

@With
@Entity
@Table(name = "Result", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"result_system", "result_name", "result_date"})
})
public class Result implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(name = "result_system")
  private String system;

  @Column(name = "result_name")
  private String name;

  @Column(name = "result_date")
  private Integer date;

  @Column(name = "result_value")
  private Integer value;

  public Result() {
  }

  public Result(Integer id, String system, String name, Integer date, Integer value) {
    this.id = id;
    this.system = system;
    this.name = name;
    this.date = date;
    this.value = value;
  }

  public Result(String system, String name, Integer date, Integer value) {
    this.system = system;
    this.name = name;
    this.date = date;
    this.value = value;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getSystem() {
    return system;
  }

  public void setSystem(String system) {
    this.system = system;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getDate() {
    return date;
  }

  public void setDate(Integer date) {
    this.date = date;
  }

  public Integer getValue() {
    return value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }
}
