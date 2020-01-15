package com.tanhao.travelbook.service;

import com.github.abel533.entity.Example;
import com.github.abel533.mapper.Mapper;
import com.tanhao.travelbook.bean.Flight;
import com.tanhao.travelbook.bean.Reservation;
import com.tanhao.travelbook.dao.FlightMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;


@Service
public class FlightService extends BaseService<Flight>{

    @Autowired
    private FlightMapper mapper;

    @Autowired
    private ReservationService reservationService;


    @Override
    protected Mapper<Flight> getMapper() {
        return this.mapper;
    }


    public List getFlightByParam(String fromCity, String arivCity, String date) throws Exception{

        //获得所有符合条件的航班，并得到它还剩下多少座位

        Example example = new Example(Flight.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("fromCity",fromCity);
        criteria.andEqualTo("arivCity",arivCity);

        List<Flight> list = mapper.selectByExample(example);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date2 = sdf.parse(date);
        Date date1 = new Date(date2.getTime());

        for(Flight flight1 : list){

            //获取该航班还剩下多少个座位
            Example example2 = new Example(Reservation.class);
            Example.Criteria criteria2 = example2.createCriteria();
            criteria2.andEqualTo("resDate",date1);
            criteria2.andEqualTo("resvKey",flight1.getFlightNum());
            int count =  reservationService.reservationMapper.selectCountByExample(example2);

            flight1.setNumSeats(flight1.getNumSeats() - count);

        }

        return list;
    }
}
