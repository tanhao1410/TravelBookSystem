package com.tanhao.travelbook.bean;

import javax.persistence.Column;
import javax.persistence.Table;
import java.sql.Date;

@Table(name="Reservation")
public class Reservation {
    @Column(name="resvKey")
    private String resvKey;
    @Column(name="custName")
    private String custName;

    @Column(name="resDate")

    private Date resDate;
    @Column(name="type")
    private int type;

    public String getResvKey() {
        return resvKey;
    }

    public void setResvKey(String resvKey) {
        this.resvKey = resvKey;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public Date getResDate() {
        return resDate;
    }

    public void setResDate(Date resDate) {
        this.resDate = resDate;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
