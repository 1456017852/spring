package com.naruto.day02.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WindowsConditionalBean implements Condition {

    /**
     * ConditionContext:
     * annotatedTypeMetadata:
     * @param conditionContext
     * @param annotatedTypeMetadata
     * @return
     */
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Environment environment=conditionContext.getEnvironment();
        //获取操作系统的名称
        String str=environment.getProperty("os.name");
        System.out.println("os.name:--->"+str);
        if(str.contains("Windows")){
            return true;
        }

        return false;
    }
}
