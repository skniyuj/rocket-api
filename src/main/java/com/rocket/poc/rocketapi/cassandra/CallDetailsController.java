package com.rocket.poc.rocketapi.cassandra;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CallDetailsController {
    
    @Autowired
    CallDetailService callDetailService;

    @RequestMapping("/cassandra/calls")
    List<CallDetail> getAllPeople(){
        return callDetailService.getAllCalls();
    }
}
