package com.jltour.service;


import com.jltour.bean.TestModel;
import com.jltour.dao.TestRepository;
import com.jltour.mappers.TestModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Roc .
 * @Description: no
 * @Date: Created in 2017/9/29 0029.
 */
@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private TestModelMapper testModelMapper;

    public List<TestModel> test(){
        return (List<TestModel>) testRepository.findAll();
    }

    public List<TestModel> mybaitesTest(){
        return testModelMapper.findById(1L);
    }

}
