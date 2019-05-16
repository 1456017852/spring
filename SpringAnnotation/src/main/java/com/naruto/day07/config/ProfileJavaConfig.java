package com.naruto.day07.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@PropertySource("classpath:/jdbc.properties")
@Configuration
public class ProfileJavaConfig implements EmbeddedValueResolverAware {

    @Value("${jdbc.user}")
    private String user;

    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.driverClass}")
    private String driverClass;

    private StringValueResolver stringValueResolver;

    private ComboPooledDataSource comboPooledDataSource=new ComboPooledDataSource();

    /**
     * 利用spring底层组件
     * @param stringValueResolver
     */

    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        this.stringValueResolver=stringValueResolver;
    }

    /**
     * 给datasource属性赋值
     * @throws PropertyVetoException
     */
    public void setDatasourceProperties ()throws PropertyVetoException{
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setDriverClass(driverClass);
    }

    @Profile("test")
    @Bean
    public DataSource dataSourceTest() throws PropertyVetoException {

        setDatasourceProperties();
        comboPooledDataSource.setJdbcUrl(stringValueResolver.resolveStringValue("${jdbc.testUrl}"));
        return comboPooledDataSource;
    }

    @Profile("dev")
    @Bean
    public DataSource dataSourceDev() throws PropertyVetoException {
        setDatasourceProperties();
        comboPooledDataSource.setJdbcUrl(stringValueResolver.resolveStringValue("${jdbc.devUrl}"));
        return comboPooledDataSource;
    }

    @Profile("online")
    @Bean
    public DataSource dataSourceOnline() throws PropertyVetoException {
        setDatasourceProperties();
        comboPooledDataSource.setJdbcUrl(stringValueResolver.resolveStringValue("${jdbc.onlineUrl}"));
        return comboPooledDataSource;
    }



}
