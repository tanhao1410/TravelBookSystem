package com.tanhao.travelbook.controller;

import com.tanhao.travelbook.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/reservation")
@Controller
class ReservationController {

    @Autowired
    ReservationService reservationService;

}