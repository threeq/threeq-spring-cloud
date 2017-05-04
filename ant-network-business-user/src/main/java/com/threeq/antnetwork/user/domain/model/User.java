package com.threeq.antnetwork.user.domain.model;

import com.threeq.network.core.model.BaseEntity;

/**
 * @Date 2017/5/4
 * @User three
 */
public class User extends BaseEntity<String> {
    private String address;
    private String city;
    private String phoneNo;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
