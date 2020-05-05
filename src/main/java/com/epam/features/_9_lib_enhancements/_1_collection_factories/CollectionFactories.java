package com.epam.features._9_lib_enhancements._1_collection_factories;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @since 9
 * @since 10 (copyOf and unmodifiable collector)
 */
public class CollectionFactories {
    public static void main(String[] args) {
        // lists
        System.out.println(List.of(1, 2, 3));
        System.out.println(Stream.of(1, 2, 3).collect(Collectors.toUnmodifiableList()));

        final var list = Stream.of(1, 2, 3).collect(Collectors.toList());
        list.add(4);
        final var unmodifiableList = List.copyOf(list);
        try {
            unmodifiableList.add(5);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // sets
        System.out.println(Set.of(1, 2, 3));

        // maps
        System.out.println(Map.of(1, 2, 3, 4));
        System.out.println(Map.ofEntries(Map.entry(1, 2), Map.entry(3, 4)));
    }
}
