package com.jltour.config.database;

import com.jltour.utils.DatabaseUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * @Author: Roc .
 * @Description: no
 * @Date: Created in 2017/10/19 0019.
 */
@Configuration
@MapperScan(basePackages = "com.jltour.mappers",sqlSessionFactoryRef = "batisSqlSessionFactory",sqlSessionTemplateRef = "batisSqlSessionTemplate")
@EnableConfigurationProperties(MyBatisProperties.class)
public class MyBatisConfig {

    @Autowired
    private MyBatisProperties myBatisProperties;

    @Bean("batisSqlSessionFactory")
    public SqlSessionFactory secondSqlSessionFactory() throws Exception {
        DataSource dataSource = DatabaseUtils.createDataSource(myBatisProperties.getDriver(), myBatisProperties.getUsername(), myBatisProperties.getPassword(), myBatisProperties.getUrl());
        return DatabaseUtils.createSessionFactory(dataSource, new PathMatchingResourcePatternResolver().getResources(myBatisProperties.getMapperLocations()), myBatisProperties.getAlias());
    }

    @Bean(name="batisSqlSessionTemplate")
    public SqlSessionTemplate secondSqlSessionTemplate(@Qualifier("batisSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
