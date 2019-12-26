package com.tanhao.travelbook.controller;

import com.tanhao.travelbook.bean.Flight;
import com.tanhao.travelbook.service.BaseService;
import com.tanhao.travelbook.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/flight")
@Controller
class FlightController extends BaseController<Flight>{

    @Autowired
    private FlightService flightService;//service注入

    @Override
    protected BaseService<Flight> getService() {
        return this.flightService;
    }


    @ResponseBody
    @RequestMapping( value="/getFlightByParam",method = RequestMethod.GET)
    public ResponseEntity getFlightByParam(@RequestParam("fromCity") String fromCity,@RequestParam("arivCity") String ArivCity,@RequestParam("date")String date) {
        try {

            ArivCity = new String(ArivCity.getBytes("ISO-8859-1"), "utf-8");
            fromCity= new String(fromCity.getBytes("ISO-8859-1"), "utf-8");
            List result = flightService.getFlightByParam(fromCity, ArivCity, date);
            return ResponseEntity.status(HttpStatus.OK).body(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);

    }


}