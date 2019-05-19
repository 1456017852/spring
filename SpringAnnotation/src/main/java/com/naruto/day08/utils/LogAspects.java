package com.naruto.day08.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 切面类
 */
@Aspect//表示该类为切面类
@Component
public class LogAspects {

    @Pointcut(value = "execution(* com.naruto.day08.*.*(..))")
    public void pointCut(){}

    @Before("com.naruto.day08.utils.LogAspects.pointCut()") //外部切面类调用切点方法的的方式
    public void logStart(JoinPoint joinPoint){
        System.out.println("@Before:【"+joinPoint.getSignature().getName()+"】开始运行"+"参数列表：{"+joinPoint.getArgs()+"}");
    }

    @After("pointCut()") //内部切面类调用切点方法的的方式
    public void logEnd(JoinPoint joinPoint){
        System.out.println("@After:【"+joinPoint.getSignature().getName()+"】运行结束"+"参数列表：{"+joinPoint.getArgs()+"}");
    }

    @AfterReturning(value = "pointCut()",returning = "result") //returning:接受返回值
    public void logReturn(JoinPoint joinPoint,Object result){
        System.out.println("@AfterReturning:【"+joinPoint.getSignature().getName()+"】运行结束"+"参数列表：{"+joinPoint.getArgs()+"}"+"返回值：{"+result+"}");
    }

    @AfterThrowing(value = "pointCut()",throwing = "exception") //throwing：接受异常
    public void logException(JoinPoint joinPoint,Exception exception){
        System.out.println("@AfterReturning:【"+joinPoint.getSignature().getName()+"】运行结束"+"参数列表：{"+joinPoint.getArgs()+"}"+"异常：{"+exception+"}");
    }

}
