package com.nivaassudhan.aoc25.solutions.day1;

import com.nivaassudhan.aoc25.models.CircularLinkedList;
import com.nivaassudhan.aoc25.models.Node;

import java.util.ArrayList;
import java.util.LinkedList;

public class Day1 {
    public static void solve() {
        System.out.println("Day 1");
        System.out.println();
        part1();
        System.out.println();
        part2();

        System.out.println();
        System.out.println("============================");
        System.out.println();
    }

    private static int checkIfDialStateIsZero(int currentVal, int passcode){
        if(currentVal==0)
            ++passcode;
        return passcode;
    }

    public static void part1(){

        System.out.println("part1:");
        ArrayList<String> list = (ArrayList<String>) utils.FileUtil.readInputFile("src/main/resources/day1/input.txt");
        CircularLinkedList dial = new CircularLinkedList();
        for (int i = 0; i <= 99; i++) {
            dial.add(i);
        }
//        dial.printList();

        Node current = dial.head;

        for(int start = 0; start<50; start++){
            current = current.next;
        }

//        System.out.println(current.value);

        int passcode = 0;
        int totalMoves = 0;

        for(String move : list){
            totalMoves++;
//            System.out.println("move: "+move);
            char direction = move.strip().charAt(0);
            int magnitude = Integer.parseInt(move.strip().substring(1));

            for(int i = 0; i < magnitude; i++){
                if (direction== 'L') {
                    current = current.prev;
                }else if (direction=='R') {
                    current = current.next;
                }
            }

            passcode = checkIfDialStateIsZero(current.value, passcode);
        }

        System.out.println("passcode: "+ passcode);
        System.out.println("totalMoves: "+ totalMoves);
    }

    public static void part2() {
        System.out.println("part2:");
        ArrayList<String> list = (ArrayList<String>) utils.FileUtil.readInputFile("src/main/resources/day1/input.txt");
        CircularLinkedList dial = new CircularLinkedList();
        for (int i = 0; i <= 99; i++) {
            dial.add(i);
        }
//        dial.printList();

        Node current = dial.head;

        for(int start = 0; start<50; start++){
            current = current.next;
        }

//        System.out.println(current.value);

        int passcode = 0;
        int totalMoves = 0;

        for(String move : list){
            totalMoves++;
//            System.out.println("move: "+move);
            char direction = move.strip().charAt(0);
            int magnitude = Integer.parseInt(move.strip().substring(1));

            for(int i = 0; i < magnitude; i++){
                if (direction== 'L') {
                    current = current.prev;
                }else if (direction=='R') {
                    current = current.next;
                }
                passcode = checkIfDialStateIsZero(current.value, passcode);
            }
        }

        System.out.println("passcode: "+ passcode);
        System.out.println("totalMoves: "+ totalMoves);
    }
}
