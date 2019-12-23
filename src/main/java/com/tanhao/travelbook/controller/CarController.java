package com.tanhao.travelbook.controller;

import com.tanhao.travelbook.bean.Car;
import com.tanhao.travelbook.bean.Flight;
import com.tanhao.travelbook.service.BaseService;
import com.tanhao.travelbook.service.CarService;
import com.tanhao.travelbook.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/car")
@Controller
class CarController extends BaseController<Car>{

    @Autowired
    private CarService carService;//service注入

    @Override
    protected BaseService<Car> getService() {
        return this.carService;
    }
}