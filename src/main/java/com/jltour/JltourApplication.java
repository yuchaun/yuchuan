package com.jltour;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @Author: Roc .
 * @Description: no
 * @Date: Created in 2017/9/29 0029.
 */
@SpringBootApplication
public class JltourApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(JltourApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(JltourApplication.class, args);
    }
}
