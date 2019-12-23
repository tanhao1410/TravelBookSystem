package com.tanhao.travelbook.controller;

import com.tanhao.travelbook.bean.Flight;
import com.tanhao.travelbook.service.BaseService;
import com.tanhao.travelbook.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/flight")
@Controller
class FlightController extends BaseController<Flight>{

    @Autowired
    private FlightService flightService;//service注入

    @Override
    protected BaseService<Flight> getService() {
        return this.flightService;
    }
}