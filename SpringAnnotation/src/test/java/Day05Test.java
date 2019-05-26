import com.naruto.day05.bean.Person;
import com.naruto.day05.bean.User;
import com.naruto.day05.config.BeanPropertyConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * day05测试类
 */
public class Day05Test {
    /**
     *  Bean属性赋值
     * @Value：直接量 、#{}
     * @Value+@PropertySource：${}
     *
     */
    ApplicationContext applicationContext=new AnnotationConfigApplicationContext(BeanPropertyConfig.class);

    @Test
    public  void testBeanProperty(){
        Person person=(Person)applicationContext.getBean("person");
        System.out.println("person"+person);
    }

    @Test
    public  void testBeanUserProperty(){
        User user=(User)applicationContext.getBean("user");
        System.out.println("user"+user);
    }


}
