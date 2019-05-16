
import com.naruto.day07.config.ProfileJavaConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * day07测试类
 */
public class Day07Test {

    /**
     * Spring的多环境
     *
     * @Profile:多环境标注，只有激活相应的环境，@Profile标识的对应环境的组件才会注册到IOC容器
     *
     * 激活方式：
     * 1、在虚拟机上添加参数:-Dspring.profiles.active=dev
     * 2、代码
     *
     */
    @Test
    public void testProfile(){
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
        //设置需要激活的环境
        applicationContext.getEnvironment().setActiveProfiles("test","dev");
        //注册配置类
        applicationContext.register(ProfileJavaConfig.class);
        //刷新容器
        applicationContext.refresh();
        String []  datasources=applicationContext.getBeanNamesForType(DataSource.class);
        for(String datasource:datasources){
            System.out.println("datasource"+datasource);
        }
    }

}
