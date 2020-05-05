package com.epam.features._9_lib_enhancements._4_completable_future_enhancements;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @since 9
 */
public class CompletableFutureEnhancements {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(toInt("1"));
        System.out.println(toInt("abc"));

        CompletableFuture.supplyAsync(() -> { while (true); })
                .orTimeout(50, TimeUnit.MICROSECONDS)
                .whenComplete((o, throwable) -> throwable.printStackTrace());

        Thread.sleep(100);
    }

    private static CompletableFuture<Integer> toInt(String str) {
        try {
            return CompletableFuture.completedFuture(Integer.valueOf(str));
        } catch (NumberFormatException ex) {
            return CompletableFuture.failedFuture(ex); // from java 9
        }
    }
}
