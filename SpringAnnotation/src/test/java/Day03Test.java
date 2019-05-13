
import com.naruto.day03.bean.Color;
import com.naruto.day03.config.ColorFactoryBean;
import com.naruto.day03.config.ImportJavaConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * day03测试类
 */
public class Day03Test {

    /**
     * 一、给容器中导入bean
     *
     *  1、@import:快速的给容器中注册一个组件(id默认全类名)
     *   例如:@Import({ Yellow.class, Green.class})
     *
     *  2、@import+ImportSelector:返回需要导入的组件的全类名数组
     *   例如:@Import({ Yellow.class, Green.class,MyImportSeleter.class})，MyImportSeleter实现ImportSelector
     *
     *  3、@Import+ImportBeanDefinitionRegistrar:手动注册bean到容器中
     *   例如：@Import({ Yellow.class, Green.class,MyImportSeleter.class,MyImportBeanDefinitionRegistrar.class})，
     *      MyImportBeanDefinitionRegistrar实现ImportBeanDefinitionRegistrar
     *
     */


    @Test
    public void getImportIOCBean(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(ImportJavaConfig.class);

        String [] colors=applicationContext.getBeanNamesForType(Color.class);
        for (String color:colors){
            System.out.println("color:--->"+color);
        }

        Color color=(Color)applicationContext.getBean("colorFactoryBean");
        System.out.println("color:--->"+color);

    }


    /**
     * 4、使用spring提供的FactoryBean(工厂Bean)
     */

    @Test
    public void getFactoryBean(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(ImportJavaConfig.class);

        //默认获取到的是工厂bean调用getObject()得到的对象
        Color color=(Color)applicationContext.getBean("colorFactoryBean");
        System.out.println("color:--->"+color);

        //如果需要获取工厂bean本身，需要在id前加上&前缀
        ColorFactoryBean colorFactoryBean=(ColorFactoryBean)applicationContext.getBean("&colorFactoryBean");
        System.out.println("colorFactoryBean:--->"+colorFactoryBean);

    }
}
