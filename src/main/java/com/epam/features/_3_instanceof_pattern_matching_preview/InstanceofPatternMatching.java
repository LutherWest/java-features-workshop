package com.epam.features._3_instanceof_pattern_matching_preview;

/**
 * @since 14 preview
 */
public class InstanceofPatternMatching {
    public static void main(String[] args) {
        final var stringOrObject = Math.random() > 0.5 ? new Object() : "abc".repeat((int) (Math.random() * 10));
        instanceofUsage(stringOrObject);
        instanceofUsageWithCondition(stringOrObject);
    }

    private static void instanceofUsage(Object arg) {
        if (arg instanceof String str) {
            System.out.printf("Passed argument - [%s] has length = %d", str, str.length());
        }
    }

    private static void instanceofUsageWithCondition(Object arg) {
        if (arg instanceof String str && str.length() > 10) {
            System.out.printf("Passed argument - [%s] has length > 10", str);
        }
    }
}
