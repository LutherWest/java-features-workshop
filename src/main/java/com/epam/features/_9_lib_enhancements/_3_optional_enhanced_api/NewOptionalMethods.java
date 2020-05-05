package com.epam.features._9_lib_enhancements._3_optional_enhanced_api;

import java.util.NoSuchElementException;
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
        final var optional = supplier.get();
        if (optional.isPresent()) {
            System.out.println(optional.get());
        } else {
            System.out.println("Optional is empty");
        }

        // or
        var opt = supplier.get();
        var resultOptional = opt.isPresent() ? opt : supplier.get();

        if (resultOptional.isPresent()) {
            System.out.println(resultOptional.get());
        } else {
            System.out.println("First and second optionals are empty!");
        }

        // stream
        Stream.generate(supplier)
                .limit(10)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(System.out::println);

        // orElseThrow
        supplier.get().orElseThrow(() -> new NoSuchElementException("Not present"));

        // isEmpty
        final var option = supplier.get();
        System.out.println(!option.isPresent());
    }
}
