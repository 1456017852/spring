package com.naruto.day09.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@PropertySource("classpath:/jdbc.properties")
@Configuration
@EnableTransactionManagement //开启事务管理功能
public class DataBaseConfig {

    @Value("${jdbc.user}")
    private String user;

    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.driverClass}")
    private String driverClass;

    @Value("${jdbc.springUrl}")
    private String url;

    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource=new ComboPooledDataSource();
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setDriverClass(driverClass);
        comboPooledDataSource.setJdbcUrl(url);
        return comboPooledDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    /**
     *
     * @param dataSource
     * @return
     */
    @Bean
    public PlatformTransactionManager platformTransactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

}
