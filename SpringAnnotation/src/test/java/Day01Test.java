import com.naruto.day01.bean.Person;
import com.naruto.day01.bean.ScopeBean;
import com.naruto.day01.bean.Student;
import com.naruto.day01.config.JavaConfig;

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
     * 3、使用ApplicationContext context= new  ClassPathXmlApplicationContext("bean.xml")获取springIOC容器对象
     * 4、容器对象context.getBean("person")获取该类的对象;
     */
    @Test
    public void getXmlConfigBean(){
        ApplicationContext context= new  ClassPathXmlApplicationContext("bean.xml");
        Person person=(Person) context.getBean("person");
        System.out.println("person:"+person);

        //获取springIOC容器中所有Bean对象的名称
        String [] StrArray=context.getBeanDefinitionNames();
        for (String beanName:StrArray){
            System.out.println("beanName:--->"+beanName);
        }
    }

    /**
     *二、java配置类方式获取springIOC容器中的Bean对象
     * 1、创建一个JavaBean(Person类)
     * 2、编写JavaConfig配置类，添加注解@Configuration
     *    @Configuration:表示这是一个配置类，相当于一个spring的配置文件,同时表示该配置类也是springIOC容器中的Bean
     * 3、创建一个方法添加@Bean注解(给容器中注册一个Bean),id为方法名称，类型为返回值类型
     * 4、ApplicationContext applicationContext=new AnnotationConfigApplicationContext(JavaConfig.class)获取springIOC容器对象
     * 5、容器对象context.getBean("person")获取该类的对象;
     *
     */
    @Test
    public void getJavaConfigBean(){

        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(JavaConfig.class);
        Person person=(Person)applicationContext.getBean("Person1");
        System.out.println("person:"+person);

        //获取springIOC容器中所有Bean对象的名称
        String [] StrArray=applicationContext.getBeanDefinitionNames();
        for (String beanName:StrArray){
            System.out.println("beanName:--->"+beanName);
        }
    }

    /**
     * 三、注解方式获取springIOC容器中的Bean对象
     * 1、创建一个JavaBean(Student类),给其添加@Component注解使其成为一个spring组件
     * 2、编写配置类JavaConfig配置类，添加注解@Configuration、@ComponentScan(自动扫描包)
     *      @Controller,@Service,@Repository,@Component标识的Bean表示为spring的组件,
     *      经过自动扫描包后，成为springIOC容器中的Bean
     * 3、ApplicationContext applicationContext=new AnnotationConfigApplicationContext(JavaConfig.class)获取springIOC容器对象
     * 4、容器对象context.getBean("student")获取该类的对象;
     */
    @Test
    public void getAnnotationBean(){

        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(JavaConfig.class);
        Student student=(Student) applicationContext.getBean("student");
        System.out.println("student:"+student);

        //获取springIOC容器中所有Bean对象的名称
        String [] StrArray=applicationContext.getBeanDefinitionNames();
        for (String beanName:StrArray){
            System.out.println("beanName:--->"+beanName);
        }
    }

    /**
     * 四.bean的作用域
     * @scope:
     *   singleton:单实例(默认值)
     *      IOC启动时会调用的方法创建bean放到IOC容器中，以后每次获取就直接从容其中获取
     *   prototype:多实例
     *      IOC启动时会调用的方法创建bean放到IOC容器中，以后每次获取时，都会调用方法创建bean放到容器中
     */


    /**
     *  单实例实例bean测试
     */
    @Test
    public void testScopeSingleton(){

        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(JavaConfig.class);
        System.out.println("IOC容器对象创建完成...");

        ScopeBean scopeBean=(ScopeBean) applicationContext.getBean("scopeBean");
        ScopeBean scopeBean1=(ScopeBean) applicationContext.getBean("scopeBean");

        System.out.println(scopeBean==scopeBean1);

    }

    /**
     * 多实例bean测试
     */
    @Test
    public void testScopePrototype(){

        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(JavaConfig.class);
        System.out.println("IOC容器对象创建完成...");

        Person person=(Person) applicationContext.getBean("Person1");
        Person person1=(Person) applicationContext.getBean("Person1");

        System.out.println(person==person1);

    }


    /**
     * 五、懒加载
     * @Lazy:专门只对于单实例bean(IOC启动时会调用的方法创建bean放到IOC容器中)
     * 懒加载：IOC启动时不会调用的方法创建bean放到IOC容器中，第一次获取bean时创建bean,并初始化
     *
     */
    @Test
    public void testScopeSingletonLazyBean(){

    ApplicationContext applicationContext=new AnnotationConfigApplicationContext(JavaConfig.class);
        System.out.println("IOC容器对象创建完成...");

    ScopeBean scopeBean=(ScopeBean) applicationContext.getBean("scopeBean");
    ScopeBean scopeBean1=(ScopeBean) applicationContext.getBean("scopeBean");

        System.out.println(scopeBean==scopeBean1);

}

}
