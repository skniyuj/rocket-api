package com.rocket.poc.rocketapi.dummy;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DummyCallsService {
    Date date = new Date(System.currentTimeMillis());
    private List<MockCall> calls = Arrays.asList(
            new MockCall(123, date, "1.2.3.4", "4.5.6.7", 4.0F),
            new MockCall(124, date, "1.2.3.4", "4.5.6.6", 4.3F),
            new MockCall(125, date, "1.2.3.4", "4.5.6.9", 4.4F)
            );

    public List<MockCall> getCalls() {
        return calls;
    }
    
    public MockCall getCalls(int id) {
        if (calls.size() > id) {
            return calls.get(id);
        } else {
            return calls.get(calls.size()-1);
        }
    }
}
