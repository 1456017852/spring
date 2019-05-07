package day01.com.naruto.config;

import day01.com.naruto.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //表示这是一个配置类，相当于一个spring的配置文件(同时也是springIOC容器中的Bean)
@ComponentScan(value="day01.com.naruto")//自动扫描包
public class JavaConfig {

    /**
     *  @Bean给容器中注册一个Bean,id为方法名称，类型为返回值类型
     * @return
     */
    @Bean("person1")
    public Person person(){
        return new Person();
    }

}
