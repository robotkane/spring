package com.tutorialspoint.e10;

import org.aspectj.lang.annotation.*;

@Aspect
public class Logging {
    @Pointcut("execution(* com.tutorialspoint.e10.*.*(..))")
    private void selectAll() {
    }

    @Before("selectAll()")
    public void beforeAdvice() {
        System.out.println("before");
    }

    @After("selectAll()")
    public void afterAdvice() {
        System.out.println("after");
    }

    @AfterReturning(pointcut = "selectAll()", returning = "retVal")
    public void afterReturningAdvice(Object retVal) {
        System.out.println("Returning:" + retVal.toString());
    }

    @AfterThrowing(pointcut = "selectAll()", throwing = "ex")
    public void afterThrowingAdvice(IllegalArgumentException ex) {
        System.out.println("There has been an exception: " + ex.toString());
    }
}
