package com.epam.features._2_switch_expression;

import java.lang.annotation.RetentionPolicy;

/**
 * @since 12 preview
 * @since 13 second preview
 * @since 14 standard
 */
public class SwitchExpression {
    public static void main(String[] args) {
        usageExample1("1");
        System.out.println(usageExample2("2"));
        System.out.println(usageExample3("1"));
        System.out.println(enumUsageExample(RetentionPolicy.CLASS));
    }

    /**
     * Rewrite with ->
     */
    private static void usageExample1(String arg) {
        switch (arg) {
            case "1" -> System.out.println("one");
            case "2" -> System.out.println("two");
            default -> System.out.println("Not one or two");
        }
    }

    /**
     * Rewrite with : yield
     */
    private static int usageExample2(String arg) {
        return switch (arg) {
            case "1": yield 1;
            case "2": yield 2;
            default: yield -1;
        };
    }

    /**
     * Rewrite with -> and yield
     */
    private static int usageExample3(String arg) {
        return switch (arg) {
            case "1" -> {
                System.out.println("one");
                yield 1;
            }
            case "2" -> {
                System.out.println("two");
                yield 2;
            }
            default -> {
                System.out.println("Not one or two");
                yield -1;
            }
        };
    }

    private static String enumUsageExample(RetentionPolicy retentionPolicy) {
        return switch (retentionPolicy) {
            case SOURCE -> "Annotations are to be discarded by the compiler.";
            case CLASS -> "Annotations are to be recorded in the class file by the compiler "
                    + "but need not be retained by the VM at run time.";
            case RUNTIME -> "Annotations are to be recorded in the class file by the compiler and "
                    + "retained by the VM at run time, so they may be read reflectively.";
        };
    }
}
