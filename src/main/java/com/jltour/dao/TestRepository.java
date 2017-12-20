package com.jltour.dao;

import com.jltour.bean.TestModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: Roc .
 * @Description: no
 * @Date: Created in 2017/9/29 0029.
 */
@Repository
public interface TestRepository extends CrudRepository<TestModel,Long>{
}
