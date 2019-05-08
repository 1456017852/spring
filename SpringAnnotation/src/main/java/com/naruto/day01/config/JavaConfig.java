package com.naruto.day01.config;

import com.naruto.day01.bean.ScopeBean;
import com.naruto.day01.bean.Student;
import com.naruto.day01.bean.Person;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @Configuration:表示这是一个配置类，相当于一个spring的配置文件(同时也是springIOC容器中的Bean)
 *
 * @ComponentScan(value="day01.com.naruto"):自动扫描包
 *  1、value：指定要扫描的包及其子包
 *  2、excludeFilters=Fiter[]:指定要排除扫描的组件
 *  3、includeFilters=Filter[]:指定要扫描的组件(使用时要关闭默认的过滤器useDefaultFilters = false)
 *  4、FilterType 指定扫描规则
 *      type = FilterType.ANNOTATION(注解)
 *      type = FilterType.ASSIGNABLE_TYPE(类型)
 *
 */
@Configuration
@ComponentScans(value={
        @ComponentScan(
                value="com.naruto.day01",//指定要扫描的包
                /*excludeFilters = { //指定要排除扫描的组件
                    @ComponentScan.Filter(
                            type = FilterType.ANNOTATION,//指定扫描规则(注解)
                            classes = {
                                    Controller.class,Service.class
                            }
                    )
                },*/
                includeFilters = { //指定要扫描的组件
                        @ComponentScan.Filter(
                                type = FilterType.ANNOTATION,
                                classes = {Controller.class, Service.class}
                        ),
                        @ComponentScan.Filter(
                                type = FilterType.ASSIGNABLE_TYPE,
                                classes = {Student.class}
                        )
                },
                useDefaultFilters = false //指定禁用默认的过滤规则*/
        )
})
public class JavaConfig {

    /**
     * 1、@Bean给容器中注册一个Bean,id为方法名称，类型为返回值类型
     *
     *   <bean id="person" class="com.naruto.day01.bean.Person" scope="prototype">
     *         <property name="id" value="1"></property>
     *         <property name="name" value="naruto"></property>
     *         <property name="age" value="18"></property>
     *   </bean>
     *
     * 2、@Scope:表示该spring创建该bean时的作用域
     *      singleton:单实例(默认值)
     *      prototype:多实例
     * @return
     */

    @Lazy //懒加载
    @Scope("singleton")
    @Bean
    public ScopeBean scopeBean(){
        System.out.println("给容器中注册ScopeBean...");
        return new ScopeBean();
    }

    @Scope("prototype")
    @Bean("Person1")
    public Person person(){
        System.out.println("给容器中注册Person...");
        return new Person();
    }
}
