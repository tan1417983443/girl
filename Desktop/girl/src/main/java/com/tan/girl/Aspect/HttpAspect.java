package com.tan.girl.Aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author 谭永超 [www.tanyongchao.tk:8090/SumDome/index]
 * @Date 2018/8/19 22:35
 * @Description 面向切面编程
 */
@Aspect
@Component
public class HttpAspect {
    private static final Logger logger = LoggerFactory.getLogger(HttpAspect.class);
    @Pointcut("execution(public * com.tan.girl.HelloWordController.hello(..))")
    // before 在方法执行之前执行
    public void log(){
        System.out.println("s");
    }
    @Before("log()")
    public void doBefore(JoinPoint jinPoint){
       ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
       HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url={}",request.getRequestURL());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类方法
        logger.info("class_method={}",jinPoint.getSignature().getDeclaringType()+"."+jinPoint.getSignature().getDeclaringTypeName());
        //参数
        logger.info("args={}",jinPoint.getArgs());
    }
    // after 在方法执行之后执行
    @After("log()")
    public void doAfter(){
        System.out.println("a");
    }
    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
    }
}
