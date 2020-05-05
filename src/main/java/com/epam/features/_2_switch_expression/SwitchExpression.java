package com.epam.features._2_switch_expression;

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
            case "1":
                System.out.println("one");
                break; // if I forget this break
            case "2":
                System.out.println("two");
                break;
            default:
                System.out.println("Not one or two");
                break;
        }
    }

    /**
     * Rewrite with : yield
     */
    private static int usageExample2(String arg) {
        final int i;
        switch (arg) {
            case "1":
                i = 1;
                break; // if I forget this break
            case "2":
                i = 2;
                break;
            default:
                i = -1;
                break;
        }
        return i;
    }

    /**
     * Rewrite with -> and yield
     */
    private static int usageExample3(String arg) {
        final int i;
        switch (arg) {
            case "1":
                System.out.println("one");
                i = 1;
                break;
            case "2":
                System.out.println("two");
                i = 2;
                break;
            default:
                System.out.println("Not one or two");
                i = -1;
                break;
        }
        return i;
    }

    private static String enumUsageExample(RetentionPolicy retentionPolicy) {
        final String javaDoc;
        switch (retentionPolicy) {
            case SOURCE:
                javaDoc = "Annotations are to be discarded by the compiler.";
                break;
            case CLASS:
                javaDoc = "Annotations are to be recorded in the class file by the compiler "
                        + "but need not be retained by the VM at run time.";
                break;
            case RUNTIME:
                javaDoc = "Annotations are to be recorded in the class file by the compiler and "
                        + "retained by the VM at run time, so they may be read reflectively.";
                break;
            default:
                throw new RuntimeException("Can't happen!");
        }
        return javaDoc;
    }

    public enum RetentionPolicy {
        SOURCE,
        CLASS,
        RUNTIME
    }
}
