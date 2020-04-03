package com.rocket.poc.rocketapi.cassandra;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CallDetailService {
    @Autowired
    private CallDetailsDao callDetailsDao;
    public List<CallDetail> getAllCalls() {
        return callDetailsDao.getAllCallDetail();
    }

    public List<CallRecord> case1_getIntervalCallDetails(int hostId, String startDay, String endDay) {
        return callDetailsDao.case1_getIntervalCallDetails(hostId, startDay, endDay);
    }

    public List<HourlyCalls> case2_getCallsInADay(int hostId, String day) {
        return callDetailsDao.case2_getCallsInADay(hostId, day);
    }

    public List<HourlyAvgMOS> case3_getIntervalMOSValues(int hostId, String startDay, String endDay) {
        return callDetailsDao.case3_getIntervalMOSValues(hostId, startDay, endDay);
    }
}
