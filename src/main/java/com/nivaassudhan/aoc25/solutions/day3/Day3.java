package com.nivaassudhan.aoc25.solutions.day3;

import java.util.ArrayList;

public class Day3 {
    public static void solve() {
        System.out.println("Day 3");
        System.out.println();
        part1();
        System.out.println();
        part2();

        System.out.println();
        System.out.println("============================");
        System.out.println();
    }

    public static void part1() {
        System.out.println("part1:");
        System.out.println();

        ArrayList<String> list = (ArrayList<String>) utils.FileUtil.readInputFile("src/main/resources/day3/input.txt");

        long totalJoltage = list.parallelStream()
                .mapToInt(Day3::calculateMaxJoltage)
                .sum();

        System.out.println(totalJoltage);
    }

    private static int calculateMaxJoltage(String numberString) {
        int maxJoltage = 0;
        int len = numberString.length();

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int digit1 = numberString.charAt(i) - '0';
                int digit2 = numberString.charAt(j) - '0';
                int current = (digit1 * 10) + digit2;

                if (current > maxJoltage) {
                    maxJoltage = current;
                    if (maxJoltage == 99) {
                        return 99;
                    }
                }
            }
        }
        return maxJoltage;
    }

    public static void part2() {
        System.out.println("part2:");
        System.out.println();

        java.util.List<String> list = utils.FileUtil.readInputFile("src/main/resources/day3/input.txt");

        long totalJoltage = 0;

        for (String bank : list) {
            totalJoltage += calculateMaxTwelveDigitJoltage(bank);
        }

        System.out.println("Total Output Joltage: " + totalJoltage);
    }

    private static long calculateMaxTwelveDigitJoltage(String bank) {
        StringBuilder resultBuilder = new StringBuilder();
        int len = bank.length();
        int currentSearchStart = 0;

        for (int digitsNeeded = 12; digitsNeeded > 0; digitsNeeded--) {

            int digitsToSave = digitsNeeded - 1;

            int searchEndInclusive = (len - 1) - digitsToSave;

            char maxDigit = '/';
            int indexFound = -1;

            for (int i = currentSearchStart; i <= searchEndInclusive; i++) {
                char c = bank.charAt(i);

                if (c > maxDigit) {
                    maxDigit = c;
                    indexFound = i;

                    if (c == '9') {
                        break;
                    }
                }
            }

            resultBuilder.append(maxDigit);

            currentSearchStart = indexFound + 1;
        }

        return Long.parseLong(resultBuilder.toString());
    }
}
