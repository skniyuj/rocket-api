package com.rocket.poc.rocketapi.cassandra;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Component;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.datastax.driver.core.querybuilder.Select.Where;
import com.datastax.driver.core.querybuilder.Clause;
import static com.datastax.driver.core.querybuilder.QueryBuilder.eq;
import static com.datastax.driver.core.querybuilder.QueryBuilder.gte;
import static com.datastax.driver.core.querybuilder.QueryBuilder.lte;
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

    // For given host, retrieve (CallId, SRC, DST, MOS) for given duration.
    public List<CallRecord> case1_getIntervalCallDetails(int hostId, String startDay, String endDay) {
        Select query =
                QueryBuilder.select("callid","src","dst","mos")
                    .from("calldetails")
                    .allowFiltering();

        // Split "yyyy-mm-dd-hh" into "yyyy", "mm", "dd", "hh"
        String[] ymdS = startDay.split("-");
        String[] ymdE = endDay.split("-");

        // Augment startDay: eg. "2020-04-01-12" to "2020-04-01 12:00:00"
        startDay = ymdS[0] + "-" + ymdS[1] + "-" + ymdS[2] + " " + ymdS[3] + ":00:00";

        // Augment endDay: eg. "2020-04-02-15" to "2020-04-01 15:00:00"
        endDay = ymdE[0] + "-" + ymdE[1] + "-" + ymdE[2] + " " + ymdE[3] + ":00:00";

        query.where(eq("hostid",hostId)).and(gte("created",startDay)).and(lte("created",endDay));

        List<CallRecord> calls =   cassandraOperations.select(query, CallRecord.class);
        return calls;
    }

    // For given host, retrieve calls happened every hours during a day.
    public List<HourlyCalls> case2_getCallsInADay(int hostId, String day) {
        Selection selectColumns = QueryBuilder.select();
        selectColumns.column("hour");
        selectColumns.count("hour").as("count");

        // Split "yyyy-mm-dd" into "yyyy", "mm", "dd".
        String[] ymd = day.split("-");

        Select query = selectColumns.from("calldetails")
             .where(eq("hostid",hostId))
             .and(eq("year",Integer.parseInt(ymd[0])))
	     .and(eq("month",Integer.parseInt(ymd[1])))
	     .and(eq("day",Integer.parseInt(ymd[2])))
	     .groupBy("year","month","day","hour")
	     .allowFiltering();

        List<HourlyCalls> calls =   cassandraOperations.select(query, HourlyCalls.class);
        return calls;
    }

    // For given host, retrieve mos values for given duration.
    public List<HourlyAvgMOS> case3_getIntervalMOSValues(int hostId, String startDay, String endDay) {
        Selection selectColumns = QueryBuilder.select();
        selectColumns.column("year");
        selectColumns.column("month");
        selectColumns.column("day");
        selectColumns.column("hour");
        selectColumns.avg("mos").as("mos");

        // Split "yyyy-mm-dd-hh" into "yyyy", "mm", "dd", "hh"
        String[] ymdS = startDay.split("-");
        String[] ymdE = endDay.split("-");

        // Augment startDay: eg. "2020-04-01-12" to "2020-04-01 12:00:00"
        startDay = ymdS[0] + "-" + ymdS[1] + "-" + ymdS[2] + " " + ymdS[3] + ":00:00";

        // Augment endDay: eg. "2020-04-02-15" to "2020-04-01 15:00:00"
        endDay = ymdE[0] + "-" + ymdE[1] + "-" + ymdE[2] + " " + ymdE[3] + ":00:00";

        Select query = selectColumns.from("calldetails")
             .where(eq("hostid",hostId))
             .and(gte("created",startDay))
	     .and(lte("created",endDay))
	     .groupBy("year","month","day","hour")
	     .allowFiltering();

        List<HourlyAvgMOS> calls =   cassandraOperations.select(query, HourlyAvgMOS.class);
        return calls;
    }
}
