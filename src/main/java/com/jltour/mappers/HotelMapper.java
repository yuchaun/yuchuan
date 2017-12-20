package com.jltour.mappers;

import com.jltour.bean.Hotel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: Roc .
 * @Description: no
 * @Date: Created in 2017/12/14 0014.
 */
@Mapper
public interface HotelMapper {

    List<Hotel> findAll();

/*    List<Hotel> selectHomeByCityGroupHotel();

    List<Hotel> selectHotelInfoByCitycode(@Param("cityCode") String cityCode);*/

    /**
     * 获取省份集合
     * @return
     */
    List<Hotel> selectProvinceNameList(@Param("start")int start,@Param("end")int end);

    //获取城市酒店数量
    int selectCityNum(@Param("cityName")String cityName);
    //获取省份数量
    int selectProvinceNum(@Param("provinceName")String provinceName);
}
