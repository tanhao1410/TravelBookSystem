package com.tanhao.travelbook.bean;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
@Table(name="car")
public class Car implements Serializable{

    @Column(name="carId")
    private String carId;
    @Column(name="cityId")
    private String cityId;
    @Column(name="carNum")
    private String carNum;
    @Column(name="price")
    private int price;

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getCarId() {
        return carId;

    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
