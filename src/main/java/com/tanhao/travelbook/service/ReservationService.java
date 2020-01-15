package com.tanhao.travelbook.service;

import com.github.abel533.entity.Example;
import com.tanhao.travelbook.bean.*;
import com.tanhao.travelbook.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ReservationService {

    @Autowired
    ReservationMapper reservationMapper;
    @Autowired
    FlightMapper flightMapper;
    @Autowired
    CarMapper carMapper;
    @Autowired
    HotelMapper hotelMapper;

    /**
     * 预约航班
     * @param flightId
     * @param custId
     * @param date
     * @throws Exception
     */
    public void reservFlight(String flightId, String custId, String date) throws Exception{

        Reservation fr = new Reservation();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date2 = sdf.parse(date);
        Date date1 = new Date(date2.getTime());

        fr.setResDate(date1);
        fr.setResvKey(flightId);
        fr.setCustName(custId);
        fr.setType(1);
        //预约一个飞机航班
        reservationMapper.insert(fr);
    }

    /**
     * 预约出租车
     * @param carNum
     * @param custName
     * @param date
     * @throws Exception
     */
    public void reservCar(String carNum, String custName, String date) throws  Exception{
        Reservation cr = new Reservation();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date2 = sdf.parse(date);
        Date date1 = new Date(date2.getTime());

        cr.setResvKey(carNum);
        cr.setCustName(custName);
        cr.setResDate(date1);
        cr.setType(3);

        reservationMapper.insert(cr);

    }

    /**
     * 预约宾馆
     * @param hotelName
     * @param custName
     * @param date
     * @throws Exception
     */
    public void reservHotel(String hotelName, String custName, String date) throws  Exception{
        Reservation hr = new Reservation();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date2 = sdf.parse(date);
        Date date1 = new Date(date2.getTime());

        hr.setCustName(custName);
        hr.setResvKey(hotelName);
        hr.setResDate(date1);
        hr.setType(2);

        reservationMapper.insert(hr);
    }

    /**
     * 获取客户的所有预约，包括航班，出租车和旅馆
     * @param custName 客户名称
     * @return
     * @throws Exception
     */
    public List getMyResvs(String custName) throws Exception{
        List result = new ArrayList();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //组织格式
        /*
        <th>预约类型</th>
        <th>班次/车牌号/宾馆名称</th>
        <th>价格</th>
        <th>地点</th>
        <th>日期</th>
        type + "
    name + "
    price +
    cityName
    date + "
         */
        //查询所有的宾馆预约
        Example hotelExample = new Example(Reservation.class);
        Example.Criteria criteria = hotelExample.createCriteria();
        criteria.andEqualTo("custName",custName);
        List<Reservation> hotelReservations = reservationMapper.selectByExample(hotelExample);
        for(Reservation  hr :hotelReservations){
            Map<String,String> map = new HashMap();

            switch (hr.getType()){
                //查询所有的航班预约
                case 1:

                    //查询出航班信息
                    Flight flight =  flightMapper.selectByPrimaryKey(hr.getResvKey());
                    map.put("type","航班预约");
                    map.put("name",flight.getFlightNum());
                    map.put("price",String.valueOf(flight.getPrice()));
                    map.put("cityName",flight.getFromCity() +"-->"+flight.getArivCity());
                    map.put("date",sdf.format(hr.getResDate()));

                    result.add(map);
                    break;
                case 2:
                    //查询出宾馆信息
                    Hotel hotel =  hotelMapper.selectByPrimaryKey(hr.getResvKey());
                    map.put("type","宾馆预约");
                    map.put("name",hotel.getHotelName());
                    map.put("price",String.valueOf(hotel.getPrice()));
                    map.put("cityName",hotel.getCityName());
                    map.put("date",sdf.format(hr.getResDate()));

                    result.add(map);
                    break;
                //查询所有的出租车预约
                case 3:

                    Car car =  carMapper.selectByPrimaryKey(hr.getResvKey());
                    map.put("type","出租车预约");
                    map.put("name",car.getCarNum());
                    map.put("price",String.valueOf(car.getPrice()));
                    map.put("cityName",car.getCityName());
                    map.put("date",sdf.format(hr.getResDate()));

                    result.add(map);
                    break;
            }
        }
        return result;
    }

    /**
     * 取消预约
     * @param custName
     * @param name
     * @param type
     */
    public void cancelResvs(String custName, String name, String type,String date) throws Exception{

        Example example = new Example(Reservation.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("custName",custName);
        criteria.andEqualTo("resvKey",name);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date2 = sdf.parse(date);
        Date date1 = new Date(date2.getTime());

        criteria.andEqualTo("resDate",date1);
        if("航班预约".equals(type)){
            criteria.andEqualTo("type",1);
        }else if("宾馆预约".equals(type)){
            criteria.andEqualTo("type",2);
        }else{
            criteria.andEqualTo("type",3);
        }
        reservationMapper.deleteByExample(example);
    }

    public List getMyTravel(String custName) {
        List result = new ArrayList();
        //查询所有的宾馆预约
        Example example = new Example(Reservation.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("custName",custName);
        criteria.andEqualTo("type",1);
        example.setOrderByClause("resDate");
        List<Reservation> reservations = reservationMapper.selectByExample(example);

        //根据预约的航班决定出发城和目的城市
        for(Reservation r :reservations){
            Flight flight = flightMapper.selectByPrimaryKey(r.getResvKey());

            Map map = new HashMap();
            map.put("fromCity",flight.getFromCity());
            map.put("arivCity",flight.getArivCity());
            map.put("flightNum",flight.getFlightNum());

            result.add(map);
        }

        return  result;
    }
}
