package com.nivaassudhan.aoc25.solutions.day2;

import java.util.concurrent.Callable;

public class RangeEvalTask implements Callable<Long> {

    private final int part;

    private final long firstId;
    private final long lastId;

    public RangeEvalTask(String range, int part) {
        this.part = part;
        String stripped = range.strip();
        int dashIndex = stripped.indexOf('-');
        this.firstId = Long.parseLong(stripped.substring(0, dashIndex));
        this.lastId = Long.parseLong(stripped.substring(dashIndex + 1));
    }

    private static long sumOfInvalidIdsInRange(long first, long last) {
        long sumOfInvalidIds = 0;
        for (long i = first; i <= last; i++) {
            String current = Long.toString(i);
            int len = current.length();
            if (len % 2 == 0) {
                String secondHalf = current.substring(len / 2);
                String firstHalf = current.substring(0, len / 2);
                if (firstHalf.equals(secondHalf)) {
                    sumOfInvalidIds = sumOfInvalidIds + i;
                }
            }
        }
        return sumOfInvalidIds;
    }

    private static long sumOfInvalidIdsInRangePart2(long first, long last) {
        long sumOfInvalidIds = 0;
        for (long i = first; i <= last; i++) {
            String current = Long.toString(i);
            String currentTwice = current.concat(current);
            String currentTwiceWithFirstAndLastClipped = currentTwice.substring(1, currentTwice.length() - 1);
            if (currentTwiceWithFirstAndLastClipped.contains(current))
                sumOfInvalidIds = sumOfInvalidIds + i;
        }
        return sumOfInvalidIds;
    }

    @Override
    public Long call() {
        System.out.println(Thread.currentThread().getName() + " processing range: " + firstId + "-" + lastId);

        return part == 1 ? sumOfInvalidIdsInRange(firstId, lastId) : sumOfInvalidIdsInRangePart2(firstId, lastId);
    }
}
