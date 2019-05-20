import com.naruto.day09.config.AutowiredConfig;
import com.naruto.day09.config.DataBaseConfig;

import com.naruto.day09.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * day09测试类
 */
public class Day09Test {

    /**
     * 事务
     *
     * 1、@EnableTransactionManagement:在配置类上添加@EnableTransactionManagement，开启事务管理
     * 2、@Transactional:在方法上添加注解,标识该方法为事务方法
     * 3、给容器中添加事务管理器
     *     @Bean
     *     public PlatformTransactionManager platformTransactionManager(DataSource dataSource){
     *         return new DataSourceTransactionManager(dataSource);
     *     }
     */
    @Test
    public void testTransaction(){

        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AutowiredConfig.class, DataBaseConfig.class);

        UserController userController=(UserController)applicationContext.getBean("userController");

        userController.insertUser();
    }

}
