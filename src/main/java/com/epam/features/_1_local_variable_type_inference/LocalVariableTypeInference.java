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
        // good places to add var
        final var str = "Hello World!";
        final var classWithLongName = new ClassWithExtraLongName();

        // bad places to add var
        final Map<String, Object> cache = new HashMap<>();
        final JobExecutionResult result = execute();

        // pay attention to inferred type
        final var obj = Math.random() > 0.5 ? new Children1() : new Children2();
        final var date = Math.random() > 0.5 ? Instant.now() : LocalDateTime.now();
    }

    // var allowed only as local variable (change String to var)
    private static String message = "message";

    private static class ClassWithExtraLongName { }

    private static class Parent { }
    private static class Children1 extends Parent {}
    private static class Children2 extends Parent {}

    private static class JobExecutionResult {}

    private static JobExecutionResult execute() {
        return new JobExecutionResult();
    }
}
