import com.naruto.day08.config.AopConfig;
import com.naruto.day08.utils.MathUitls;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * day08测试类
 */
public class Day08Test {
    /**
     * 一、面向切面：aop
     *  指在程序运行期间，动态的将某段代码切入到指定到方法的指定位置处进行运行的变成方式
     *
     *  1、导入依赖的spring-aspects
     *  2、定义业务逻辑类MathUitls
     *  3、定义切面类LogAspects
     *      通知方法：
     *          前置通知：(@Before) --logStart
     *          后置通知：(@After)   --logEnd
     *          返回通知：(@AfterReturning) --logReturn
     *          异常通知：(@AfterThrowing) --logException
     *          环绕通知：(@Round)
     *  4、
     */
    @Test
    public void testAop(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AopConfig.class);
        MathUitls mathUitls=(MathUitls)applicationContext.getBean("mathUitls");
        mathUitls.mul(1,2);
    }

}
