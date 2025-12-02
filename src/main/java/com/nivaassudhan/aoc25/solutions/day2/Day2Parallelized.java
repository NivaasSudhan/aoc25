package com.nivaassudhan.aoc25.solutions.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Day2Parallelized {

    private static ArrayList<String> ranges = null;

    private static final int SAFETHREADPOOLSIZE = 5;

    private static void getRangesFromInputFile(String filename) {
        ranges = utils.FileUtil.readCSV(filename);
    }

    public static void solve() throws ExecutionException, InterruptedException {
        System.out.println("Day 2");
        getRangesFromInputFile("src/main/resources/day2/input.txt");
        System.out.println();
        part1();
        System.out.println();
        part2();
    }

    public static void part1() throws InterruptedException, ExecutionException {
        System.out.println("Part 1");

        long sumTotalInvalidIds = 0;

        List<Future<Long>> futures;
        try (ExecutorService executorService = Executors.newFixedThreadPool(SAFETHREADPOOLSIZE)) {

            List<Callable<Long>> tasks = new ArrayList<>();
            for (String range : ranges) {
                tasks.add(new RangeEvalTask(range, 1));
            }

            futures = executorService.invokeAll(tasks);

            for (Future<Long> future : futures) {
                sumTotalInvalidIds = sumTotalInvalidIds + future.get();
            }

            executorService.shutdown();
        }

        System.out.println(sumTotalInvalidIds);
    }

    public static void part2() throws InterruptedException, ExecutionException {
        System.out.println("Part 2");

        long sumTotalInvalidIds = 0;

        List<Future<Long>> futures;
        try (ExecutorService executorService = Executors.newFixedThreadPool(SAFETHREADPOOLSIZE)) {

            List<Callable<Long>> tasks = new ArrayList<>();
            for (String range : ranges) {
                tasks.add(new RangeEvalTask(range, 2));
            }

            futures = executorService.invokeAll(tasks);

            for (Future<Long> future : futures) {
                sumTotalInvalidIds = sumTotalInvalidIds + future.get();
            }

            executorService.shutdown();
        }

        System.out.println(sumTotalInvalidIds);
    }
}
