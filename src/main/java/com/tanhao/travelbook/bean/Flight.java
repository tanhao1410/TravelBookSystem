package com.tanhao.travelbook.bean;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name="flight")
public class Flight  implements Serializable {

    @Column(name="flightId")
    private String flightId;
    @Column(name="flightNum")
    private String flightNum;
    @Column(name="price")
    private int price;
    @Column(name="numSeats")
    private int numSeats;
    @Column(name="fromCity")
    private String fromCity;
    @Column(name="arivCity")
    private String arivCity;

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getArivCity() {
        return arivCity;
    }

    public void setArivCity(String arivCity) {
        this.arivCity = arivCity;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }

}
