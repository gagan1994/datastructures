package com.varmints.linkedlists;

public class LinkedListMain {
    public static void main(String[] args) {
        LinkedList linkedList = getLinkedList();
//        LinkedList linkedList = getLoopLinkedList();
//        linkedList.display();
//        linkedList.checkLoop();
//        linkedList.findElement(10);
//        linkedList.deleteItem(5);
//        linkedList.deleteAll();
//        linkedList.fetchLength();
//        linkedList.middle();
//        linkedList.checkLoop();
//        LinkedList linkedList = getPalindromeLinkedList();
        linkedList.display();
        linkedList.checkPalindrome();

    }

    private static LinkedList getPalindromeLinkedList() {
        LinkedList linkedList = new LinkedList(new Node(1));
        linkedList.push(2);
        linkedList.push(2);
        linkedList.push(1);
        return linkedList;
    }

    private static LinkedList getLoopLinkedList() {
        LinkedList linkedList = new LinkedList(new Node(1));
        linkedList.push(2);
        linkedList.push(3);
        linkedList.push(4);
        linkedList.push(5);
        Node node = linkedList.push(6);
        node.next = linkedList.head;
        return linkedList;
    }

    private static LinkedList getLinkedList() {
        LinkedList linkedList = new LinkedList(new Node(1));
        linkedList.push(2);
        linkedList.push(3);
        linkedList.push(4);
        linkedList.push(5);
        linkedList.push(6);
        linkedList.push(7);
        return linkedList;
    }

}
