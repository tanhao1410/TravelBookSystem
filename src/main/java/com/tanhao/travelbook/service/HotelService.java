package com.tanhao.travelbook.service;

import com.github.abel533.mapper.Mapper;
import com.tanhao.travelbook.bean.Flight;
import com.tanhao.travelbook.bean.Hotel;
import com.tanhao.travelbook.dao.FlightMapper;
import com.tanhao.travelbook.dao.HotelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HotelService extends BaseService<Hotel>{

    @Autowired
    private HotelMapper mapper;

    @Override
    protected Mapper<Hotel> getMapper() {
        return this.mapper;
    }


}
