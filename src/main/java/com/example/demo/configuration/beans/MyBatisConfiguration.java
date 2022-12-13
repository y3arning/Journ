package com.example.demo.configuration.beans;

import com.example.demo.configuration.settings.DatabaseProperties;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.example.demo.dao")
@MapperScan("com.example.demo.dao")
@EnableTransactionManagement
public class MyBatisConfiguration {
    private DatabaseProperties databaseProperties;



    @Autowired
    public MyBatisConfiguration(DatabaseProperties databaseProperties){
        this.databaseProperties = databaseProperties;


    }
    @Bean
    public DataSource springDataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl(databaseProperties.getUrl());
        ds.setUsername(databaseProperties.getUsername());
        ds.setPassword(databaseProperties.getPassword());
        ds.setInitialSize(5);
        ds.setDefaultAutoCommit(false);
        ds.setEnableAutoCommitOnReturn(false);
        ds.setMaxTotal(50);
        return ds;
    }

    @Bean
    public org.apache.ibatis.session.Configuration configuration() {
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setReturnInstanceForEmptyRow(true);
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        return configuration;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(org.apache.ibatis.session.Configuration configuration) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(springDataSource());
        factoryBean.setConfiguration(configuration);
        return factoryBean.getObject();
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager() {
        return new DataSourceTransactionManager(springDataSource());
    }


}
