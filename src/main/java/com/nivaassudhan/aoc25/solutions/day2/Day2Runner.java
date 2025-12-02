package com.nivaassudhan.aoc25.solutions.day2;

import java.util.concurrent.ExecutionException;

public class Day2Runner {

    public static void runComparison() {
        System.out.println("Starting Day 2 Comparison...");
        System.out.println("--------------------------------------------------");

        // Run Sequential Solution
        System.out.println("Running Sequential Solution (Day2)...");
        long startTimeSequential = System.currentTimeMillis();
        Day2.solve();
        long endTimeSequential = System.currentTimeMillis();
        long durationSequential = endTimeSequential - startTimeSequential;
        System.out.println("Sequential Finished in " + durationSequential + " ms");

        System.out.println("--------------------------------------------------");

        // Run Parallelized Solution
        System.out.println("Running Parallelized Solution (Day2Parallelized)...");
        long startTimeParallel = System.currentTimeMillis();
        try {
            Day2Parallelized.solve();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        long endTimeParallel = System.currentTimeMillis();
        long durationParallel = endTimeParallel - startTimeParallel;
        System.out.println("Parallelized Finished in " + durationParallel + " ms");

        System.out.println("--------------------------------------------------");
        System.out.println("Comparison Complete.");
    }
}
