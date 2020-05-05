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
        final String str = "Hello World!";
        System.out.println(str);

        final ClassWithExtraLongName name = new ClassWithExtraLongName();
        final Map<String, Object> cache = new HashMap<>();
        System.out.println(name);
        System.out.println(cache);

        final var l = Math.random() > 0.5 ? (byte) 1 : 1L;
        final var obj = Math.random() > 0.5 ? new Children1() : new Children2();
        final var date = Math.random() > 0.5 ? Instant.now() : LocalDateTime.now();
    }
    
    private static class ClassWithExtraLongName { }

    private static class Parent { }
    private static class Children1 extends Parent {}
    private static class Children2 extends Parent {}
}
