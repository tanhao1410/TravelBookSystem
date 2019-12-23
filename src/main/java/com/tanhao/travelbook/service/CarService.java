package com.tanhao.travelbook.service;

import com.github.abel533.mapper.Mapper;
import com.tanhao.travelbook.bean.Car;
import com.tanhao.travelbook.bean.Flight;
import com.tanhao.travelbook.dao.CarMapper;
import com.tanhao.travelbook.dao.FlightMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarService extends BaseService<Car>{

    @Autowired
    private CarMapper mapper;

    @Override
    protected Mapper<Car> getMapper() {
        return this.mapper;
    }


}
