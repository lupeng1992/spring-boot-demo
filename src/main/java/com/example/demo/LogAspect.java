package com.example.demo;

import com.example.demo.context.SystemContext;
import com.example.demo.entity.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class LogAspect {

    @Pointcut("@annotation(com.example.demo.Action)")
    public void annotationPointCut() {
        System.out.println("annotationPointCut");
    }

    @AfterReturning(value = "annotationPointCut()",returning = "returnValue")
    public void after(JoinPoint joinPoint,Object returnValue) {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        Object[] args = joinPoint.getArgs();
        System.out.println("注解式拦截之后" + action.name());
    }

    @Before("annotationPointCut()")
    public void before(JoinPoint joinPoint){
        User currentPerson = SystemContext.getCurrentPerson();
        System.out.println(currentPerson);
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("注解式拦截之前" + action.name());

    }



}
