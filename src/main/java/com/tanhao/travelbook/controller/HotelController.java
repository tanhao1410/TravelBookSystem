package com.tanhao.travelbook.controller;

import com.tanhao.travelbook.bean.Hotel;
import com.tanhao.travelbook.service.BaseService;
import com.tanhao.travelbook.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/hotel")
@Controller
class HotelController extends BaseController<Hotel>{

    @Autowired
    private HotelService hotelService;//service注入

    @Override
    protected BaseService<Hotel> getService() {
        return this.hotelService;
    }
}