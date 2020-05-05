package com.epam.features._6_final_var_in_try;

/**
 * @since 9
 */
public class EffectivelyFinalVarInTryWithResources {
    public static void main(String[] args) {
        System.out.println(doAndReturn());
    }

    private static StatefulResource doAndReturn() {
        StatefulResource resource = new StatefulResource();
        try (resource) {
            System.out.println(resource);
        }
        return resource;
    }

    private static class StatefulResource implements AutoCloseable {
        @Override
        public void close() {
            System.out.println("Resource closed");
        }
    }
}
