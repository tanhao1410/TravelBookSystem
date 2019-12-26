package com.tanhao.travelbook.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Table(name="car")
public class Car implements Serializable{

    @Column(name="cityName")
    private String cityName;
    @Id
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

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
