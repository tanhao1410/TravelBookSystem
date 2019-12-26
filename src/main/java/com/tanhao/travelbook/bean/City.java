package com.tanhao.travelbook.bean;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
@Table(name="city")
public class City implements Serializable {

    @Column(name="cityName")
    private String cityName;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
