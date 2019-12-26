package com.tanhao.travelbook.service;

import com.github.abel533.entity.Example;
import com.tanhao.travelbook.bean.FlightReservation;
import com.tanhao.travelbook.dao.CarReservationMapper;
import com.tanhao.travelbook.dao.FlightReservationMapper;
import com.tanhao.travelbook.dao.HotelReservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.UUID;

@Service
public class ReservationService {

    @Autowired
    CarReservationMapper carReservationMapper;
    @Autowired
    HotelReservationMapper hotelReservationMapper;
    @Autowired
    FlightReservationMapper flightReservationMapper;


    public void reservFlight(String flightId, String custId, String date) throws Exception{

        FlightReservation fr = new FlightReservation();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date2 = sdf.parse(date);
        Date date1 = new Date(date2.getTime());

        fr.setResDate(date1);
        fr.setFlightId(flightId);
        fr.setCustId(custId);
        fr.setId(UUID.randomUUID().toString());
        //预约一个飞机航班
        flightReservationMapper.insert(fr);
    }

    public void flightReservCancel(String id) {
        //取消航班
        flightReservationMapper.deleteByPrimaryKey(id);
    }
}
