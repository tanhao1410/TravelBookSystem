package com.tanhao.travelbook.service;

import com.github.abel533.mapper.Mapper;
import com.tanhao.travelbook.bean.Flight;
import com.tanhao.travelbook.dao.FlightMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FlightService extends BaseService<Flight>{

    @Autowired
    private FlightMapper mapper;

    @Override
    protected Mapper<Flight> getMapper() {
        return this.mapper;
    }


}
