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
    CarReservationMapper carReservationMapper;
    @Autowired
    HotelReservationMapper hotelReservationMapper;
    @Autowired
    FlightReservationMapper flightReservationMapper;
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

        FlightReservation fr = new FlightReservation();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date2 = sdf.parse(date);
        Date date1 = new Date(date2.getTime());

        fr.setResDate(date1);
        fr.setFlightNum(flightId);
        fr.setCustName(custId);
        //预约一个飞机航班
        flightReservationMapper.insert(fr);
    }

    /**
     * 预约出租车
     * @param carNum
     * @param custName
     * @param date
     * @throws Exception
     */
    public void reservCar(String carNum, String custName, String date) throws  Exception{
        CarReservation cr = new CarReservation();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date2 = sdf.parse(date);
        Date date1 = new Date(date2.getTime());

        cr.setCarNum(carNum);
        cr.setCustName(custName);
        cr.setResDate(date1);

        carReservationMapper.insert(cr);

    }

    /**
     * 预约宾馆
     * @param hotelName
     * @param custName
     * @param date
     * @throws Exception
     */
    public void reservHotel(String hotelName, String custName, String date) throws  Exception{
        HotelReservation hr = new HotelReservation();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date2 = sdf.parse(date);
        Date date1 = new Date(date2.getTime());

        hr.setCustName(custName);
        hr.setHotelName(hotelName);
        hr.setResDate(date1);

        hotelReservationMapper.insert(hr);
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
        Example hotelExample = new Example(HotelReservation.class);
        Example.Criteria criteria = hotelExample.createCriteria();
        criteria.andEqualTo("custName",custName);
        List<HotelReservation> hotelReservations = hotelReservationMapper.selectByExample(hotelExample);
        for(HotelReservation  hr :hotelReservations){
            Map<String,String> map = new HashMap();

            //查询出宾馆信息
           Hotel hotel =  hotelMapper.selectByPrimaryKey(hr.getHotelName());
           map.put("type","宾馆预约");
           map.put("name",hotel.getHotelName());
           map.put("price",String.valueOf(hotel.getPrice()));
           map.put("cityName",hotel.getCityName());
           map.put("date",sdf.format(hr.getResDate()));

           result.add(map);

        }
        //查询所有的航班预约
        Example flightExample = new Example(FlightReservation.class);
        Example.Criteria criteria2 = flightExample.createCriteria();
        criteria2.andEqualTo("custName",custName);
        List<FlightReservation> flightReservations = flightReservationMapper.selectByExample(flightExample);
        for(FlightReservation  fr :flightReservations){
            Map<String,String> map = new HashMap();

            //查询出航班信息
            Flight flight =  flightMapper.selectByPrimaryKey(fr.getFlightNum());
            map.put("type","航班预约");
            map.put("name",flight.getFlightNum());
            map.put("price",String.valueOf(flight.getPrice()));
            map.put("cityName",flight.getFromCity() +"-->"+flight.getArivCity());
            map.put("date",sdf.format(fr.getResDate()));

            result.add(map);

        }
        //查询所有的出租车预约
        Example carExample = new Example(CarReservation.class);
        Example.Criteria criteria3 = carExample.createCriteria();
        criteria3.andEqualTo("custName",custName);
        List<CarReservation> carReservations = carReservationMapper.selectByExample(carExample);
        for(CarReservation  cr :carReservations){
            Map<String,String> map = new HashMap();

            //查询出航班信息
            Car car =  carMapper.selectByPrimaryKey(cr.getCarNum());
            map.put("type","出租车预约");
            map.put("name",car.getCarNum());
            map.put("price",String.valueOf(car.getPrice()));
            map.put("cityName",car.getCityName());
            map.put("date",sdf.format(cr.getResDate()));

            result.add(map);

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

        if("航班预约".equals(type)){
            Example flightExample = new Example(FlightReservation.class);
            Example.Criteria criteria = flightExample.createCriteria();
            criteria.andEqualTo("custName",custName);
            criteria.andEqualTo("flightNum",name);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date2 = sdf.parse(date);
            Date date1 = new Date(date2.getTime());

            criteria.andEqualTo("resDate",date1);
            flightReservationMapper.deleteByExample(flightExample);
        }else if("宾馆预约".equals(type)){

        }else{

        }
    }
}
