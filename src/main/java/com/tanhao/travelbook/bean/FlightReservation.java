package com.tanhao.travelbook.bean;

import javax.persistence.Column;
import javax.persistence.Table;
import java.sql.Date;

@Table(name="FlightReservation")
public class FlightReservation {

    @Column(name="id")
    private String id;
    @Column(name="flightId")
    private String flightId;
    @Column(name="custId")
    private String custId;
    @Column(name="resDate")
    private Date resDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
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
}
