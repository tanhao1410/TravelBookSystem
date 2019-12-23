package com.tanhao.travelbook.bean;

import java.io.Serializable;

public class City implements Serializable {

    private String cityName;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
