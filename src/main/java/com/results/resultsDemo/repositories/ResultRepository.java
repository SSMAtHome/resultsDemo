package com.results.resultsDemo.repositories;

import com.results.resultsDemo.model.Result;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<Result, Integer> {

  @Query("select m from Result m where m.system = :system and m.name = :name and m.date = :date")
  Result getResultBySystemAndNameAndDate(
      @Param("system") String system, @Param("name") String name, @Param("date") Integer date);

  @Query(
      "select m from Result m where m.system = :system "
          + "and (:name is null or m.name = :name) "
          + "and (:fromDate is null or m.date >= :fromDate) "
          + "and (:toDate is null or m.date < :toDate)")
  List<Result> getResultsGroupBySystemFromDateToDate(
      @Param("system") String system,
      @Param("name") String name,
      @Param("fromDate") Integer fromDate,
      @Param("toDate") Integer toDate);
}
