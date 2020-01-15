package com.tanhao.travelbook.bean;

import javax.persistence.Column;
import javax.persistence.Id;

public class Customer {

    @Column(name="password")
    private String password;
    @Id
    @Column(name="custName")
    private String custName;
    @Column(name="type")
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }
}
