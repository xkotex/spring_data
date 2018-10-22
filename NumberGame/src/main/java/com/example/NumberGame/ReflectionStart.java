package com.example.NumberGame;

import com.example.NumberGame.controller.TestController;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectionStart {
    public static void main(String[] args) {
        TestController controller = new TestController(null);
        Class testControllerClass = controller.getClass();

        for(Constructor constructor : testControllerClass.getConstructors()){
            System.out.println(constructor);
        }

        for(Annotation annotation: testControllerClass.getAnnotations()){
            System.out.println(annotation);
        }
        System.out.println("Methods");
        for (Method method:testControllerClass.getMethods()){
            System.out.println(method);
        }
        System.out.println("Declared Methods");
        for (Method method:testControllerClass.getDeclaredMethods()){
            System.out.println(method);
        }
    }
}
