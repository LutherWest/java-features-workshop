package com.epam.features._1_local_variable_type_inference;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @since 9
 */
public class LocalVariableTypeInference {
    public static void main(String[] args) {
        final var str = "Hello World!";
        System.out.println(str);

        final var name = new ClassWithExtraLongName();
        final var cache = new HashMap<>();
        System.out.println(name instanceof ClassWithExtraLongName);
        System.out.println(cache instanceof Map);
        System.out.println(cache instanceof HashMap);

        final var l = Math.random() > 0.5 ? (byte) 1 : 1L;
        final var obj = Math.random() > 0.5 ? new Children1() : new Children2();
        final var date = Math.random() > 0.5 ? Instant.now() : LocalDateTime.now();
    }
    
    private static class ClassWithExtraLongName { }

    private static class Parent { }
    private static class Children1 extends Parent {}
    private static class Children2 extends Parent {}
}
