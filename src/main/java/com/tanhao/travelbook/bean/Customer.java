package com.tanhao.travelbook.bean;

import javax.persistence.Column;
import javax.persistence.Id;

public class Customer {

    @Column(name="password")
    private String password;
    @Id
    @Column(name="custName")
    private String custName;

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
