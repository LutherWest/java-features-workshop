package com.epam.features._9_lib_enhancements._5_stack_walker;

import java.util.Objects;

/**
 * @since 9
 */
public class StackWalkerApi {
    public static void main(String[] args) {
        method1();
    }

    private static void method1() {
        method2();
    }

    private static void method2() {
        method3();
    }

    private static void method3() {
        method4();
    }

    private static void method4() {
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (Objects.equals(stackTraceElement.getMethodName(), "main")) {
                System.out.println(stackTraceElement);
            }
        }
    }
}
