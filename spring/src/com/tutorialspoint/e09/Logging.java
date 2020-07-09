package com.tutorialspoint.e09;

public class Logging {
    public void beforeAdvice() {
        System.out.println("begin");
    }

    public void afterAdvice() {
        System.out.println("after");
    }

    public void afterReturningAdvice(Object retVal) {
        System.out.println("Returning:" + retVal.toString());
    }

    public void afterThrowingAdvice(IllegalArgumentException ex) {
        System.out.println("There has been an exception: " + ex.toString());
    }
}
