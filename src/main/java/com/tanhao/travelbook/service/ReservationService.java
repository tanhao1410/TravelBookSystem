package com.tanhao.travelbook.service;

import com.tanhao.travelbook.dao.CarReservationMapper;
import com.tanhao.travelbook.dao.FlightReservationMapper;
import com.tanhao.travelbook.dao.HotelReservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    CarReservationMapper carReservationMapper;
    @Autowired
    HotelReservationMapper hotelReservationMapper;
    @Autowired
    FlightReservationMapper flightReservationMapper;


}
