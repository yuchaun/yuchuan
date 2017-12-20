package com.jltour.bean.map;

import lombok.Data;

import java.util.List;

/**
 * Created by Administrator on 2017/12/17 0017.
 */
public class GdMapBaseInfo {

    private String status;

    private String info;

    private String infocode;

    private String count;

    private List<GeoCodes> geocodes;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfocode() {
        return infocode;
    }

    public void setInfocode(String infocode) {
        this.infocode = infocode;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public List<GeoCodes> getGeocodes() {
        return geocodes;
    }

    public void setGeocodes(List<GeoCodes> geocodes) {
        this.geocodes = geocodes;
    }
}
