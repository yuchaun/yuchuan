package com.jltour.service;


import com.jltour.bean.map.GdMapBaseInfo;
import com.jltour.utils.GdMapProperties;
import com.jltour.utils.HttpUtil;
import com.jltour.utils.JsonUtil;
import com.jltour.utils.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by jr on 2017/12/17 0017.
 * 高德地图
 */
@Service
public class GdMapService {

    @Autowired
    private GdMapProperties gdMapProperties;

    public String getLatitudeAndlongitude(String address) {
        Map map = MapUtil.generate(new String[]{"key","address"}, new Object[]{gdMapProperties.getKey(),address});
        try {
            String result = HttpUtil.sendGet(gdMapProperties.getUrl(),map,null,"UTF-8");
            GdMapBaseInfo gdMapBaseInfo = JsonUtil.toBean(result, GdMapBaseInfo.class);
            if ("1".equals(gdMapBaseInfo.getStatus())) {
                return gdMapBaseInfo.getGeocodes().get(0).getProvince();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private Map<String,String> pareamLatitudeAndLongitude(String location) {
        String[] positions = location.split(",");
        Map map = MapUtil.generate(new String[]{"latitude", "longitude"}, new Object[]{positions[0], positions[1]});
        return map;
    }

}
