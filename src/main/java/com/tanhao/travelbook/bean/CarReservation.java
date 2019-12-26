package com.tanhao.travelbook.bean;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
@Table(name="CarReservation")
public class CarReservation implements Serializable{
    @Column(name="resDate")
    private Date resDate;
    @Column(name="id")
    private String id;
    @Column(name="carId")
    private String carId;
    @Column(name="custId")
    private String custId;

    public Date getResDate() {
        return resDate;
    }

    public void setResDate(Date resDate) {
        this.resDate = resDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }
}
