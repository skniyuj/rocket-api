package com.rocket.poc.rocketapi.dummy;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyCallsController {

    @Autowired
    private DummyCallsService dummyCallsService;

    @RequestMapping("/calls")
    public List<MockCall> getAllcalls() {
       return dummyCallsService.getCalls();
    }

    @RequestMapping("/calls/{id}")
    public MockCall getAllcall(@PathVariable int id) {
        return dummyCallsService.getCalls(id);
     }
}
