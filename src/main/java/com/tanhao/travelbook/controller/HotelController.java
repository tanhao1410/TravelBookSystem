package com.tanhao.travelbook.controller;

import com.tanhao.travelbook.bean.Hotel;
import com.tanhao.travelbook.service.BaseService;
import com.tanhao.travelbook.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@RequestMapping("/hotel")
@Controller
class HotelController extends BaseController<Hotel>{

    @Autowired
    private HotelService hotelService;//service注入

    @Override
    protected BaseService<Hotel> getService() {
        return this.hotelService;
    }

    @ResponseBody
    @RequestMapping( value="/getHotelByParam",method = RequestMethod.GET)
    public ResponseEntity getHotelByParam(@RequestParam("cityName") String cityName, @RequestParam("date")String date) {
        try {

            cityName = new String(cityName.getBytes("ISO-8859-1"), "utf-8");
            List result = hotelService.getHotelByParam(cityName, date);
            return ResponseEntity.status(HttpStatus.OK).body(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);

    }
}