package com.tanhao.travelbook.service;

import com.github.abel533.entity.Example;
import com.github.abel533.mapper.Mapper;
import com.tanhao.travelbook.bean.Car;
import com.tanhao.travelbook.bean.Reservation;
import com.tanhao.travelbook.dao.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


@Service
public class CarService extends BaseService<Car>{

    @Autowired
    private CarMapper mapper;

    @Autowired
    private ReservationService reservationService;

    @Override
    protected Mapper<Car> getMapper() {
        return this.mapper;
    }


    //返回可以被预约的所有出租车
    public List getCarByParam(String cityName, String date) throws Exception{

        List<Car> result = new ArrayList();

        Example example = new Example(Car.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("cityName",cityName);
        //该城市所有的出租车
        List<Car> list = mapper.selectByExample(example);

        //需要过滤的 在某一天被预约过的

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date2 = sdf.parse(date);
        Date date1 = new Date(date2.getTime());

        Reservation cr = new Reservation();

        for(Car car:list){
            cr.setResDate(date1);
            cr.setResvKey(car.getCarNum());

            Example example2 = new Example(Reservation.class);
            Example.Criteria criteria2 = example2.createCriteria();
            criteria2.andEqualTo("resDate", date1);
            criteria2.andEqualTo("resvKey", car.getCarNum());
            int count = reservationService.reservationMapper.selectCountByExample(example2);
            if(count == 0){
                result.add(car);
            }
        }
        return result;
    }
}
