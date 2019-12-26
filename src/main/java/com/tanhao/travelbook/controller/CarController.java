package com.tanhao.travelbook.controller;

import com.tanhao.travelbook.bean.Car;
import com.tanhao.travelbook.service.BaseService;
import com.tanhao.travelbook.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@RequestMapping("/car")
@Controller
class CarController extends BaseController<Car>{

    @Autowired
    private CarService carService;//service注入

    @ResponseBody
    @RequestMapping( value="/getCarByParam",method = RequestMethod.GET)
    public ResponseEntity getFlightByParam(@RequestParam("cityName") String cityName,  @RequestParam("date")String date) {
        try {
            cityName = new String(cityName.getBytes("ISO-8859-1"), "utf-8");
            List result = carService.getCarByParam(cityName,  date);
            return ResponseEntity.status(HttpStatus.OK).body(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);

    }

    @Override
    protected BaseService<Car> getService() {
        return this.carService;
    }
}