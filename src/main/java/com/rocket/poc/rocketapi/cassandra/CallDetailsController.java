package com.rocket.poc.rocketapi.cassandra;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class CallDetailsController {
    
    @Autowired
    CallDetailService callDetailService;

    @CrossOrigin(origins="*")
    @RequestMapping("/cassandra/calls")
    List<CallDetail> getAllPeople(){
        return callDetailService.getAllCalls();
    }

    @CrossOrigin(origins="*")
    @RequestMapping("/host/{hostId:[\\d]+}/records/{startDay:\\d{4}-\\d{2}-\\d{2}-\\d{2}}/{endDay:\\d{4}-\\d{2}-\\d{2}-\\d{2}}")
    @ResponseBody
    public List<CallRecord> case1_getIntervalCallDetails(@PathVariable("hostId") int hostId, @PathVariable("startDay") String startDay, @PathVariable("endDay") String endDay){
        return callDetailService.case1_getIntervalCallDetails(hostId, startDay, endDay);
    }

    @CrossOrigin(origins="*")
    @RequestMapping("/host/{hostId:[\\d]+}/calls/{day:\\d{4}-\\d{2}-\\d{2}}")
    @ResponseBody
    public List<HourlyCalls> case2_getCallsInADay(@PathVariable("hostId") int hostId, @PathVariable("day") String day){
        return callDetailService.case2_getCallsInADay(hostId, day);
    }

    @CrossOrigin(origins="*")
    @RequestMapping("/host/{hostId:[\\d]+}/mos/{startDay:\\d{4}-\\d{2}-\\d{2}-\\d{2}}/{endDay:\\d{4}-\\d{2}-\\d{2}-\\d{2}}")
    @ResponseBody
    public List<HourlyAvgMOS> case3_getIntervalMOSValues(@PathVariable("hostId") int hostId, @PathVariable("startDay") String startDay, @PathVariable("endDay") String endDay){
        return callDetailService.case3_getIntervalMOSValues(hostId, startDay, endDay);
    }
}
