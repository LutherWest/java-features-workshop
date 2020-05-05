package com.epam.features._8_other_changes._4_null_pointer_exception;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Run with -XX:+ShowCodeDetailsInExceptionMessages
 * @since 14
 */
public class HelpfulNullPointerException {
    public static void main(String[] args) {
        final Supplier<String> strSupplier = () -> Math.random() > 0.5 ? null : "Hello!";

        final Function<String, String> strFunction = s -> Math.random() > 0.5 ? null : s.repeat(2);

        System.out.println(strSupplier.get().transform(strFunction).length());
    }
}
