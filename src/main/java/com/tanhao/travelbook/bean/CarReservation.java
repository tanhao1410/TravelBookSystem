package com.tanhao.travelbook.bean;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
@Table(name="CarReservation")
public class CarReservation implements Serializable{
    @Column(name="resDate")
    private Date resDate;
    @Column(name="carNum")
    private String carNum;
    @Column(name="custName")
    private String custName;

    public Date getResDate() {
        return resDate;
    }

    public void setResDate(Date resDate) {
        this.resDate = resDate;
    }


    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }
}
