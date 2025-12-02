package com.nivaassudhan.aoc25.solutions.day2;

import java.util.ArrayList;

public class Day2 {

    private static ArrayList<String> ranges = null;

    private static void getRangesFromInputFile(String filename){
        ranges = utils.FileUtil.readCSV(filename);
    }

    public static void solve() {
        System.out.println("Day 2");
        getRangesFromInputFile("src/main/resources/day2/input.txt");
        System.out.println();
        part1();
        System.out.println();
        part2();

        System.out.println();
        System.out.println("============================");
        System.out.println();
    }

    private static long sumOfInvalidIdsInRange(long first, long last){
        long sumOfInvalidIds = 0;
        for(long i = first; i<=last; i++){
            String current = Long.toString(i);
            int len = current.length();
            if(len%2==0){
                String secondHalf = current.substring(len/2);
                String firstHalf = current.substring(0,len/2);
                if(firstHalf.equals(secondHalf)){
                    sumOfInvalidIds = sumOfInvalidIds+i;
                }
            }
        }
        return sumOfInvalidIds;
    }

    private static long sumOfInvalidIdsInRangePart2(long first, long last){
        long sumOfInvalidIds = 0;
        for(long i = first; i<=last; i++){
            String current = Long.toString(i);
            String currentTwice = current.concat(current);
            String currentTwiceWithFirstAndLastClipped = currentTwice.substring(1, currentTwice.length()-1);
            if(currentTwiceWithFirstAndLastClipped.contains(current))
                sumOfInvalidIds = sumOfInvalidIds+i;
        }
        return sumOfInvalidIds;
    }

    public static void part1(){
        System.out.println("Part 1");



        long sumTotalInvalidIds = 0;

        for(String range: ranges) {
            String[] limits = range.strip().split("-");
            long firstId = Long.parseLong(limits[0]);
            long lastId = Long.parseLong(limits[1]);
            sumTotalInvalidIds = sumTotalInvalidIds + sumOfInvalidIdsInRange(firstId, lastId);
        }

        System.out.println(sumTotalInvalidIds);
    }

    public static void part2(){
        System.out.println("Part 2");



        long sumTotalInvalidIds = 0;

        for(String range: ranges) {
            String[] limits = range.strip().split("-");
            long firstId = Long.parseLong(limits[0]);
            long lastId = Long.parseLong(limits[1]);
            sumTotalInvalidIds = sumTotalInvalidIds + sumOfInvalidIdsInRangePart2(firstId, lastId);
        }

        System.out.println(sumTotalInvalidIds);
    }
}
