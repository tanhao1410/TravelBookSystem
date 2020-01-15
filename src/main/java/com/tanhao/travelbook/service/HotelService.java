package com.tanhao.travelbook.service;

import com.github.abel533.entity.Example;
import com.github.abel533.mapper.Mapper;
import com.tanhao.travelbook.bean.Hotel;
import com.tanhao.travelbook.bean.Reservation;
import com.tanhao.travelbook.dao.HotelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;


@Service
public class HotelService extends BaseService<Hotel> {

    @Autowired
    private HotelMapper mapper;

    @Autowired
    private ReservationService reservationService;

    @Override
    protected Mapper<Hotel> getMapper() {
        return this.mapper;
    }


    public List getHotelByParam(String cityName, String date) throws Exception {

        Example example = new Example(Hotel.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("cityName", cityName);

        List<Hotel> list = mapper.selectByExample(example);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date2 = sdf.parse(date);
        Date date1 = new Date(date2.getTime());

        for (Hotel hotel : list) {
            //获取该航班还剩下多少个座位
            Example example2 = new Example(Reservation.class);
            Example.Criteria criteria2 = example2.createCriteria();
            criteria2.andEqualTo("resDate", date1);
            criteria2.andEqualTo("resvKey", hotel.getHotelName());
            int count = reservationService.reservationMapper.selectCountByExample(example2);
            hotel.setNumRooms(hotel.getNumRooms() - count);
        }

        return list;
    }
}
