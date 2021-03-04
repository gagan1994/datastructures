package com.varmints.linkedlists;

public class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
    }
    public Node(int val,Node node) {
        this.val = val;
        this.next = node;
    }
}
