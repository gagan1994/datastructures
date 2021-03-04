package com.varmints.linkedlists;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LinkedList {
    public Node head;

    public LinkedList(Node head) {
        this.head = head;
    }

    public Node push(int val) {
        Node node = new Node(val, null);
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = node;
        return node;
    }

    public static void display(Node node) {
        Set<Node> nodes = new HashSet<>();
        while (node != null && !nodes.contains(node)) {
            System.out.print(node.val + " ");
            nodes.add(node);
            node = node.next;
        }
    }

    public void display() {
        display(head);
    }

    public void deleteItem(int ele) {
        Node temp = head;
        Node prev = head;
        while (temp != null) {
            if (temp.val == ele) {
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Ele: " + ele + " not found");
        } else {
            System.out.println("Ele: " + ele + "  found deleting");
            prev.next = temp.next;
            temp.next = null;
            System.out.println("Ele Deleted");
        }
        display(head);
    }

    public void findElement(int ele) {
        Node temp = head;
        while (temp != null) {
            if (temp.val == ele) {
                break;
            }
            temp = temp.next;
        }
        System.out.println(" element: " + ele + " " + (temp != null ? "Found" : "Not found"));
    }

    public void deleteAll() {
        head = null;
    }

    public void fetchLength() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        System.out.println("Length is " + count);
    }

    public void middle() {
        Node temp1 = head;
        Node temp2 = head;

        while (temp1 != null) {
            if (temp1.next == null || temp1.next.next == null) {
                break;
            }
            temp1 = temp1.next.next;
            temp2 = temp2.next;
        }
        System.out.println("middle ele is " + temp2.val);
    }

    public void checkLoop() {
        Node temp = head;
        Set<Node> nodes = new HashSet<>();
        while (temp != null) {
            if (!nodes.contains(temp)) {
                System.out.println("Has loop");
                return;
            }
            temp = temp.next;
        }
    }

    public void checkPalindrome() {
        Node temp=head;
        Stack<Integer> nodes=new Stack<>();
        while (temp!=null){
            nodes.push(temp.val);
            temp=temp.next;
        }
        temp=head;
        while (temp!=null){
            if(temp.val!=nodes.pop()){
                System.out.println("Not palindrome");
                return;
            }
            temp=temp.next;
        }
        System.out.println("palindrome");

    }
}
