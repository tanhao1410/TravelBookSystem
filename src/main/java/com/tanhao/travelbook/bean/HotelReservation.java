package com.tanhao.travelbook.bean;

import javax.persistence.Column;
import javax.persistence.Table;
import java.sql.Date;
@Table(name="HotelReservation")
public class HotelReservation {
    @Column(name="id")
    private String id;
    @Column(name="hotelId")
    private String hotelId;
    @Column(name="custId")
    private String custId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public Date getResDate() {
        return resDate;
    }

    public void setResDate(Date resDate) {
        this.resDate = resDate;
    }

    private Date resDate;
}
