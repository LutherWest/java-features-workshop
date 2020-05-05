package com.epam.features._9_lib_enhancements._3_optional_enhanced_api;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @since 9
 * @since 10 (orElseThrow)
 * @since 11 (isEmpty)
 */
public class NewOptionalMethods {
    public static void main(String[] args) {
        Supplier<Optional<String>> supplier = () -> Math.random() > 0.5
                ? Optional.empty()
                : Optional.of(String.valueOf(Math.random()));

        // ifPresentOrElse
        supplier.get()
                .ifPresentOrElse(System.out::println, () -> System.out.println("Optional is empty"));

        // or
        supplier.get()
                .or(() -> supplier.get())
                .ifPresentOrElse(System.out::println, () -> System.out.println("Optional is empty"));

        // stream
        Stream.generate(supplier)
                .limit(10)
                .flatMap(Optional::stream)
                .forEach(System.out::println);

        // orElseThrow
        supplier.get().orElseThrow();

        // isEmpty
        final var option = supplier.get();
        System.out.println(option.isEmpty());
    }
}
