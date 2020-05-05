package com.epam.features._4_records_preview;

import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @since 14 preview
 */
public class Runner {
    public static void main(String[] args) {
        badUsage();
        usageOfInstanceMethods();
        usageInStreamPipeline();
        usageAsMapKey();
    }

    private static void badUsage() {
        try {
            System.out.println(Tuple2.of(null, null));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void usageOfInstanceMethods() {
        final var tuple = Tuple2.of("a", "b");
        System.out.println(tuple);
        System.out.println(tuple.map1(str -> str.repeat(5)));
        System.out.println(tuple.map2(str -> str.repeat(10)));
        System.out.println(tuple);
    }

    private static void usageInStreamPipeline() {
        final var stringToLength = Stream.of("a", "bb", "ccc", "dddd")
                .map(str -> Tuple2.of(str, str.length()))
                .peek(System.out::println)
                .collect(Collectors.toMap(Tuple2::_1, Tuple2::_2));
        System.out.println(stringToLength);
    }

    private static void usageAsMapKey() {
        final var cache = new HashMap<Tuple2<Integer, Integer>, String>();
        cache.put(Tuple2.of(1, 1), "a");
        cache.put(Tuple2.of(1, 2), "b");
        cache.put(Tuple2.of(2, 1), "c");
        cache.put(Tuple2.of(1, 1), "d");
        System.out.println(cache);
    }
}
