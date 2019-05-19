package com.naruto.day08.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 切面类
 */
@Aspect//标识该类为切面类
@Component
public class LogAspects {
    /**
     * 切点
     */
    @Pointcut(value = "execution(* com.naruto.day08.utils.*.*(..))") //定义切点
    public void pointCut(){}

    /**
     * 前置通知
     * JoinPoint joinPoint：如果要用JoinPoint，则其必须是参数列表的第一个参数
     * @param joinPoint
     */
    @Before("com.naruto.day08.utils.LogAspects.pointCut()") //外部切面类调用切点方法的的方式
    public void logStart(JoinPoint joinPoint){
        System.out.println("@Before:【"+joinPoint.getSignature().getName()+"】开始运行,"+"参数列表：{"+joinPoint.getArgs()+"}");
    }
    /**
     * 后置通知
     * @param joinPoint
     */
    @After("pointCut()") //内部切面类调用切点方法的的方式
    public void logEnd(JoinPoint joinPoint){
        System.out.println("@After:【"+joinPoint.getSignature().getName()+"】运行结束,"+"参数列表：{"+joinPoint.getArgs()+"}");
    }

    /**
     * 返回通知
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value = "pointCut()",returning = "result") //returning:接受返回值
    public void logReturn(JoinPoint joinPoint,Object result){
        System.out.println("@AfterReturning:【"+joinPoint.getSignature().getName()+"】运行结束,"+"参数列表：{"+joinPoint.getArgs()+"}"+"返回值：{"+result+"}");
    }

    /**
     * 异常通知
     * @param joinPoint
     * @param exception
     */
    @AfterThrowing(value = "pointCut()",throwing = "exception") //throwing：接受异常
    public void logException(JoinPoint joinPoint,Exception exception){
        System.out.println("@AfterThrowing:【"+joinPoint.getSignature().getName()+"】运行结束"+"参数列表：{"+joinPoint.getArgs()+"}"+"异常：{"+exception+"}");
    }

}
