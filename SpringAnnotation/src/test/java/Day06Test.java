import com.naruto.day06.config.AutowiredJavaConfig;

import com.naruto.day06.controller.PersonController;
import com.naruto.day06.controller.StudentController;
import com.naruto.day06.service.PersonService;
import com.naruto.day06.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * day06测试类
 */
public class Day06Test {

    /**
     * 一、@Autowired自动装配
     *
     * spring利用依赖注入(DI),完成IOC容器中各个组件的组装(即各组件之间的依赖)
     *
     *  1、@required ：是否必须装配
     *
     *      required=true(默认):必须装配，容器中不存在该组件时，则报错
     *      required=false:不必须装配，容器中不存在该组件时，不会注入
     */
    @Test
    public void testAutoWired(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AutowiredJavaConfig.class);

        PersonController personController=(PersonController)applicationContext.getBean("personController");
        System.out.println("personController---"+personController);

        PersonService personService=(PersonService)applicationContext.getBean("personService");
        System.out.println("personService---"+personService);

    }

     /**
      *
      * 容器中有多个相同类型的组件时：默认按照ID装配容器中的组件
      *
      * 2、@Qualifier:指定装配特定的组件
      *     @Qualifier("personService2")
      *     @Autowired(required = true)
      *
      * 3、@Primary:告诉组件首选装配该Bean(要让@Primary起作用,不能使用@Qualifier)
      *     @Primary
      *     @Bean(name = "personService2")
      */
    @Test
    public void testAutoWiredByType(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AutowiredJavaConfig.class);

        String [] personServices=applicationContext.getBeanNamesForType(PersonService.class);
        for (String personService:personServices){
            System.out.println("personService:--->"+personService);
        }

        PersonController personController=(PersonController)applicationContext.getBean("personController");
        System.out.println("personService:"+personController.printPersonFlag());


    }

    /**
     *二、spring还支持@Resource(JSR250)和@Inject(JSR330)
     *  @Resource:java规范的注解，按照组件名称实现自动装配,不支持required和@Primry
     *  @Inject:需要导入javax.inject的包来支持该注解，用法除了不支持required，其他和@Autowried差不多
     */
    @Test
    public void testResource(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AutowiredJavaConfig.class);

        StudentController studentController=(StudentController)applicationContext.getBean("studentController");
        System.out.println("studentController---"+studentController);

        StudentService studentService=(StudentService)applicationContext.getBean("studentService");
        System.out.println("studentService---"+studentService);





    }



}
