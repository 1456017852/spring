import com.naruto.day02.bean.User;
import com.naruto.day02.config.ConditionalJavaConfig;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * day02测试类
 */
public class Day02Test {

    /**
     * 一、条件化注册bean
     * @Conditional
     */


    @Test
    public void getConditonalBean(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(ConditionalJavaConfig.class);

        String [] users=applicationContext.getBeanNamesForType(User.class);
        for (String user:users){
            System.out.println("user:--->"+user);
        }


    }
}
