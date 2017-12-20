package com.jltour.config.database;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: Roc .
 * @Description: no
 * @Date: Created in 2017/10/19 0019.
 */
@ConfigurationProperties(prefix = "mybatis")
@Data
public class MyBatisProperties {

    private String url;

    private String username;

    private String password;

    private String driver;

    private String mapperLocations;

    private String alias;
}
