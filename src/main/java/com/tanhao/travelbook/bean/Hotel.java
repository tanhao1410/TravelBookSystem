package com.tanhao.travelbook.bean;

import javax.persistence.Column;
import javax.persistence.Id;

public class Hotel {

    @Id
    @Column(name="hotelName")
    private String hotelName;

    @Column(name="cityName")
    private String cityName;
    @Column(name="price")
    private int price;
    @Column(name="numRooms")
    private int numRooms;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumRooms() {
        return this.numRooms;
    }

    public void setNumRooms(int numRooms) {
        this.numRooms = numRooms;
    }

}
