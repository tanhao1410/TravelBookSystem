package com.tanhao.travelbook.bean;

import javax.persistence.Column;
import javax.persistence.Table;
import java.sql.Date;
@Table(name="HotelReservation")
public class HotelReservation {
    @Column(name="hotelName")
    private String hotelName;
    @Column(name="custName")
    private String custName;
    @Column(name="resDate")
    private Date resDate;

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hot) {
        this.hotelName = hot;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public Date getResDate() {
        return resDate;
    }

    public void setResDate(Date resDate) {
        this.resDate = resDate;
    }
}
