package com.example.demo.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {

    //数据源1
    @Bean(name="datasource1")
    @ConfigurationProperties(prefix="spring.datasource.test1")
    public DataSource dataSource1(){
        return DataSourceBuilder.create().build();
    }
    //数据源2
    @Bean(name="datasource2")
    @ConfigurationProperties(prefix="spring.datasource.test2")
    public DataSource dataSource2(){
        return DataSourceBuilder.create().build();
    }

    //配置动态数据源，通过aop切换数据源
    @Primary
    @Bean(name="dynamicDataSource")
    public DataSource dynamicDataSource(){
        DynamicDataSource dynamicDataSource = new DynamicDataSource();

        dynamicDataSource.setDefaultTargetDataSource(dataSource1());

        Map<Object, Object> dbMap = new HashMap<Object, Object>();

        dbMap.put("datasource1", dataSource1());
        dbMap.put("datasource2", dataSource2());

        dynamicDataSource.setTargetDataSources(dbMap);
        return dynamicDataSource;
    }

    //配置Transaction，统一管理
    @Bean(name="transactionManager")
    public PlatformTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dynamicDataSource());
    }


}
