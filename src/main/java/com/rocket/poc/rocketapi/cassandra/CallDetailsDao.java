package com.rocket.poc.rocketapi.cassandra;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Component;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;

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
}
