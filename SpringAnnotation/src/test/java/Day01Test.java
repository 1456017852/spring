import day01.com.naruto.bean.Person;
import day01.com.naruto.config.JavaConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * day01测试类
 */
public class Day01Test {

    /**
     * 一、xml配置文件的方式获取springIOC容器中的Bean对象
     * 1、创建一个JavaBean(Person类)
     * 2、在spring的xml配置文件中配置该JavaBean,使其注册到springIOC容器中
     *      <bean id="person" class="day01.com.naruto.bean.Person"></bean>
     * 3、使用ApplicationContext context= new  ClassPathXmlApplicationContext("bean.xml")
     *      获取springIOC容器对象
     * 4、容器对象context.getBean("person")获取该类的对象;
     */
    @Test
    public void getXmlConfigBean(){
        ApplicationContext context= new  ClassPathXmlApplicationContext("bean.xml");
        Person person=(Person) context.getBean("person");
        System.out.println("person:--->"+person);

        //获取springIOC容器中所有Bean对象的名称
        String [] StrArray=context.getBeanDefinitionNames();
        for (String beanName:StrArray){
            System.out.println("beanName:--->"+beanName);
        }
    }


    /**
     *二、java配置类方式获取springIOC容器中的Bean对象
     * 1、创建一个JavaBean(Person类)
     * 2、编写JavaConfig配置类，添加注解@Configuration表示这是一个配置类，
     *    相当于一个spring的配置文件(同时也是springIOC容器中的Bean)
     *    @Bean给容器中注册一个Bean,id为方法名称，类型为返回值类型
     * 3、ApplicationContext applicationContext=new AnnotationConfigApplicationContext(JavaConfig.class)
     *    获取springIOC容器对象
     * 4、容器对象context.getBean("person")获取该类的对象;
     *
     */
    @Test
    public void getJavaConfigBean(){

        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(JavaConfig.class);
        Person person=(Person)applicationContext.getBean("person");
        System.out.println("person:"+person);

        //获取springIOC容器中所有Bean对象的名称
        String [] StrArray=applicationContext.getBeanDefinitionNames();
        for (String beanName:StrArray){
            System.out.println("beanName:"+beanName);
        }
    }

    /**
     * 二、注解方式获取springIOC容器中的Bean对象
     * 1、创建一个JavaBean(Student类),给其添加@Component注解使其成为一个spring组件
     * 2、编写配置类Java
     */
    @Test
    public void getAnnotationBean(){


    }


}
