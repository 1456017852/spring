package com.naruto.day02.config;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LinuxConditionalBean implements Condition {

    /**
     * ConditionContext:
     * annotatedTypeMetadata:
     * @param conditionContext
     * @param annotatedTypeMetadata
     * @return
     */
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Environment environment=conditionContext.getEnvironment();
        String str=environment.getProperty("os.name");
        if(str.contains("linux")){
            return true;
        }

        return false;
    }
}
