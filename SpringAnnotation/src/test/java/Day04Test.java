import com.naruto.day04.bean.Bird;
import com.naruto.day04.bean.Car;
import com.naruto.day04.bean.Cat;
import com.naruto.day04.config.BeanLifeCycleConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * day04测试类
 */
public class Day04Test {

    /**
     * Bean的生命周期
     *
     * 1、bean的生命周期：bean创建-初始化-获取使用-销毁
     *  springIOC容器管理bean的生命周期
     *  (1)创建：
     *      单实例：在容器启动时创建对象
     *      多实例：在每次获取对象时
     *  (2)初始化：指定初始化方法：@Bean(initMethod = "init")
     *      对象创建完成，并完成赋值，调用初始化
     *  (3)销毁：指定销毁方法：@Bean(destroyMethod = "destory")
     *      单实例：容器关闭时
     *      多实例：容器不会管理这个bean的销毁
     *
     * 2、自定义初始化和销毁方法的几种方法:
     *  方法(1)：@Bean(initMethod = "init",destroyMethod = "destory")
     *  方法(2)：通过让bean实现InitializingBean, DisposableBean接口
     *          InitializingBean的afterPropertiesSet()方法实现初始化逻辑
     *          DisposableBean的destroy()方法实现销毁逻辑
     *  方法(3):JSR250
     *      @PostConstruct:在bean创建完成并且属性赋值完成，来执行初始化方法
     *      @PreDestory:在容器销毁bean之前，通知进行清理工作
     * 3、spring为我们提供了一个组件：BeanPostProcessor接口(Bean的后置处理器)
     *  这个组件主要是在Bean初始化前后进行一些处理工作
     *  postProcessBeforeInitialization()：bean初始化之前,调用
     *  postProcessAfterInitialization():bean初始化之后，调用
     *
     *
     */
    @Test
    public void testBeanLifeCycle(){

        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(BeanLifeCycleConfig.class);
        System.out.println("容器创建完成");

        Car car=(Car)applicationContext.getBean("car");
        System.out.println("获取car");

        Cat cat=(Cat)applicationContext.getBean("cat");
        System.out.println("获取cat");

        Bird bird=(Bird)applicationContext.getBean("bird");
        System.out.println("获取bird");

        //关闭容器
        ((AnnotationConfigApplicationContext) applicationContext).close();
        System.out.println("容器关闭");

    }


}
