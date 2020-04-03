package com.rocket.poc.rocketapi.cassandra;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Component;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.datastax.driver.core.querybuilder.Select.Selection;

@Component
public class CallDetailsDao {
    @Autowired
    private CassandraOperations cassandraOperations;
    
    public List<CallDetail> getAllCallDetail() {
        Select query =
                QueryBuilder.select()
                    .from("calldetails")
                    .allowFiltering();
          List<CallDetail> calls =   cassandraOperations.select(query, CallDetail.class);
          return calls;
    }

    public List<CallCount> getAllCallCount() {
        Selection selectColumns = QueryBuilder.select();
        selectColumns.column("hour");
        selectColumns.count("hour").as("count");
        Select query = selectColumns.from("calldetails")
                .where(QueryBuilder.eq("hostid", 5771))
                .and(QueryBuilder.eq("year", 2017))
                .and(QueryBuilder.eq("month", 2))
                .and(QueryBuilder.eq("day", 3))
                .groupBy(
                        QueryBuilder.column("year"),
                        QueryBuilder.column("month"),
                        QueryBuilder.column("day"),
                        QueryBuilder.column("hour"))
                    .allowFiltering();
          List<CallCount> calls =   cassandraOperations.select(query, CallCount.class);
          return calls;
    }
}
