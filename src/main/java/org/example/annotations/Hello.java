package org.example.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Hello {
    public static void main(String[] args) throws NoSuchMethodException {


        Class hello = Hello.class;
        Method method = hello.getDeclaredMethod("printHello");
        Method method2 = hello.getDeclaredMethod("printHello2");
        Annotation annotation = method.getDeclaredAnnotation(Academinfo.class);
        Annotation annotation2 = method2.getDeclaredAnnotation(Academinfo.class);
        System.out.println(annotation);
        System.out.println(annotation2);
    }
    @Academinfo(year = 2026)
    public static void printHello() {
        System.out.println("Hello, World!");
    }
    public static void printHello2(){
        System.out.println("Hello, World!!!!!!!");
    }
}