
import com.naruto.day03.bean.Color;
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
     *  1、@import:快速的给容器中注册一个组件(id默认全类名)
     *   例如:@Import({ Yellow.class, Green.class,MyImportSeleter.class})
     *  2、ImportSelector:返回需要导入的组件的全类名数组
     *   例如：@Import({MyImportSeleter.class})，MyImportSeleter实现ImportSelector
     */


    @Test
    public void getConditonalBean(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(ImportJavaConfig.class);

        String [] colors=applicationContext.getBeanNamesForType(Color.class);
        for (String color:colors){
            System.out.println("color:--->"+color);
        }


    }
}
