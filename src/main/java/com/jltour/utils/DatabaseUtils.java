package com.jltour.utils;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.Resource;

public class DatabaseUtils {
    public static DataSource createDataSource(String driver, String username, String password, String url){
        DataSource dataSource = new DataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        return dataSource;
    }

    public static SqlSessionFactory createSessionFactory(DataSource dataSource, Resource[] mapperLocations, String typeAlias) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(mapperLocations);
        sessionFactory.setTypeAliasesPackage(typeAlias);
        return sessionFactory.getObject();

    }
}
