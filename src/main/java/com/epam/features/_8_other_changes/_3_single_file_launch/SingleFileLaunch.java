package com.epam.features._8_other_changes._3_single_file_launch;

import java.time.Instant;

/**
 * @since 11
 */
public class SingleFileLaunch {
    public static void main(String[] args) {
        System.out.printf("Hello, %s!%n", args[0]);
        System.out.println("Now is - " + Instant.now());
    }
}
