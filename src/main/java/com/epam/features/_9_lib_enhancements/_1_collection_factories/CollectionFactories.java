package com.epam.features._9_lib_enhancements._1_collection_factories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @since 9
 * @since 10 (copyOf and unmodifiable collector)
 */
public class CollectionFactories {
    public static void main(String[] args) {
        // lists
        System.out.println(Arrays.asList(1, 2, 3));
        System.out.println(new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
        }});
        System.out.println(Stream.of(1, 2, 3).collect(Collectors.toList()));

        // sets
        System.out.println(new HashSet<>(Arrays.asList(1, 2, 3)));
        System.out.println(new HashSet<>() {{
            add(1);
            add(2);
            add(3);
        }});

        // maps
        System.out.println(new HashMap<>() {{
            put(1, 2);
            put(3, 4);
        }});
    }
}
