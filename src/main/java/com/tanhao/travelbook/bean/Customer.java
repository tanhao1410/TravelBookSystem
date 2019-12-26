package com.tanhao.travelbook.bean;

import javax.persistence.Column;

public class Customer {

    @Column(name="custId")
    private String custId;
    @Column(name="password")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name="custName")
    private String custName;

    public String getCustName() {
        return custName;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }
}
