package com.results.resultsDemo.repositories;

import com.results.resultsDemo.model.Result;
import com.results.resultsDemo.model.ResultSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultSummaryRepository extends JpaRepository<Result, Integer> {

  @Query(
      "SELECT sum(value) "
          + " FROM Result R "
          + " WHERE R.system = :resultSystem "
          + " AND (:resultName is null or R.name = :resultName) "
          + " AND (:fromDate is null or R.date >= :fromDate) "
          + " AND (:toDate is null or R.date < :toDate) ")
  Integer getResultSummaryValue(
      @Param("resultSystem") String system,
      @Param("resultName") String name,
      @Param("fromDate") Integer fromDate,
      @Param("toDate") Integer toDate);
}
