package com.jltour.bean.map;

import lombok.Data;

/**
 * Created by Jr on 2017/12/17 0017.
 * 高德地图
 */
public class GdMap {

    private String formatted_address;

    private String province;

    private String city;

    private String location;

    public String getFormatted_address() {
        return formatted_address;
    }

    public void setFormatted_address(String formatted_address) {
        this.formatted_address = formatted_address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
