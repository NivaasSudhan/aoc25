package com.nivaassudhan.aoc25.models;

public class CircularLinkedList {
    public Node head = null;
    public Node tail = null;
    public int size = 0;

    // Add a new node to the end of the list
    public void add(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            // First node: points to itself
            head = newNode;
            tail = newNode;
            head.next = head;
            head.prev = head;
        } else {
            // Add to the end (tail)
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head; // CIRCULAR LINK
            head.prev = newNode; // CIRCULAR LINK
            tail = newNode;      // Update tail
        }
        size++;
    }

    // Helper to print and verify circularity
    public void printList() {
        if (head == null) return;
        Node current = head;
        do {
            System.out.print(current.value + " <-> ");
            current = current.next;
        } while (current != head);
        System.out.println("(back to head)");
    }
}
