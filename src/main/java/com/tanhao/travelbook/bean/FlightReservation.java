package com.tanhao.travelbook.bean;

import javax.persistence.Column;
import javax.persistence.Table;
import java.sql.Date;

@Table(name="FlightReservation")
public class FlightReservation {

    @Column(name="flightNum")
    private String flightNum;
    @Column(name="custName")
    private String custName;
    @Column(name="resDate")
    private Date resDate;

    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
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
