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
    
    public List<CallCount> getAllCallCount() {
        return callDetailsDao.getAllCallCount();
    }
}
