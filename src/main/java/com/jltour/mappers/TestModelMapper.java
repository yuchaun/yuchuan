package com.jltour.mappers;


import com.jltour.bean.TestModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: Roc .
 * @Description: no
 * @Date: Created in 2017/9/29 0029.
 */
@Mapper
public interface TestModelMapper {
    List<TestModel> findById(@Param("id") Long id);
}
