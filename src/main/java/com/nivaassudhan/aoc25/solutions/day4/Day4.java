package com.nivaassudhan.aoc25.solutions.day4;

import java.util.ArrayList;

public class Day4 {

    static int height = 0;
    static int width = 0;
    static int[][] copy;

    public static void solve() {
        System.out.println("Day 4");
        System.out.println();
        part1();
        System.out.println();
        part2();

        System.out.println();
        System.out.println("============================");
        System.out.println();
    }

    public static int checkAccessibleRolls(ArrayList<String> list){
        int accessibleRolls = 0;

        for (int i = 0; i < height; i++) {
            char[] charArray = list.get(i).toCharArray();
            for (int j = 0; j < width; j++) {
                if (charArray[j] == '@') {
                    int neighbors = 0;
                    for (int row = i - 1; row <= i + 1; row++) {
                        for (int col = j - 1; col <= j + 1; col++) {
                            if (row >= 0 && row < height && col >= 0 && col < width) {
                                if (!(row == i && col == j)) {
                                    if (list.get(row).charAt(col) == '@')
                                        neighbors++;
                                }
                            }
                        }
                    }
                    if (neighbors < 4) {
                        accessibleRolls++;
                        copy[i][j] = 1;
                    }
                }
            }
            list.set(i,new String(charArray));
        }
        System.out.println(accessibleRolls);
        return accessibleRolls;
    }

    public static void part1() {
        System.out.println("Part 1");
        System.out.println();

        ArrayList<String> list = (ArrayList<String>) utils.FileUtil.readInputFile("src/main/resources/day4/input.txt");

        // list dimensions
        int height = list.size();
        int width = list.getFirst().length();
        int[][] copy = new int[height][width];

        checkAccessibleRolls(list);
    }

    public static void part2() {
        System.out.println("Part 2");
        System.out.println();

        ArrayList<String> list = (ArrayList<String>) utils.FileUtil.readInputFile("src/main/resources/day4/input.txt");

        height = list.size();
        width = list.getFirst().length();
        copy = new int[height][width];

        int paperRolls = 0;
        while(checkAccessibleRolls(list)>0){
            paperRolls += checkAccessibleRolls(list);
            for(int i = 0; i < height; i++){
                for(int j = 0; j < width; j++){
                    if(copy[i][j]>0){
                        char[] row = list.get(i).toCharArray();
                        row[j] = '.';
                        list.set(i,new String(row));
                    }
                }
            }
        }

        System.out.println(paperRolls);
    }
}