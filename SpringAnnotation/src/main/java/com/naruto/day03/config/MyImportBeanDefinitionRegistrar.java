package com.naruto.day03.config;

import com.naruto.day03.bean.Blue;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * annotationMetadata: 当前配置类的注解元信息
     * beanDefinitionRegistry:Bean注册定义类，把所有需要注册到容器中的bean;
     *  调用registerBeanDefinition()方法手动注册进IOC容器
     *  调用
     * @param annotationMetadata
     * @param beanDefinitionRegistry
     */
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata,
                                        BeanDefinitionRegistry beanDefinitionRegistry) {

        System.out.println(annotationMetadata);

        //判断iod容器中是否包含com.naruto.day03.bean.Block
        boolean bool1=beanDefinitionRegistry.containsBeanDefinition("com.naruto.day03.bean.Block");
        //
        boolean bool2=beanDefinitionRegistry.containsBeanDefinition("com.naruto.day03.bean.Green");

        if(bool1&&bool2){
            //向ioc容器中手动注册一个bean
            beanDefinitionRegistry.registerBeanDefinition("blue",new RootBeanDefinition(Blue.class));
        }


    }
}
