package com.tarams.algorithmanddesignpattern;

import org.junit.Test;

import java.util.HashSet;

public class LinkedListEx {
    @Test
    public void findMidElement() {
        LinkedListNode linkedList = new LinkedListNode();
        linkedList.add(new Nodes("One"));
        linkedList.add(new Nodes("Two"));
        linkedList.add(new Nodes("Three"));
        linkedList.add(new Nodes("Four"));
        linkedList.add(new Nodes("Five"));
        linkedList.printList();

        Nodes current = linkedList.head.next;
        Nodes middle = linkedList.head.next;
        while (current.next != null && current != null) {
            current = current.next.next;
            middle = middle.next;
        }
        System.out.println("mid element: " + middle.currentValue);
    }

    @Test
    public void detactLoop() {
        LinkedListNode linkedList = new LinkedListNode();
        linkedList.add(new Nodes("One"));
        Nodes two = new Nodes("Two");
        linkedList.add(two);
        linkedList.add(new Nodes("Three"));
        linkedList.add(new Nodes("Four"));
        linkedList.add(new Nodes("Five"));
        linkedList.add(two);
        Nodes current = linkedList.head.next;
        HashSet<Nodes> nodes = new HashSet<>();
        boolean hasLoop = false;
        while (current != null) {
            if (nodes.contains(current)) {
                hasLoop = true;
                break;
            }
            nodes.add(current);
            current = current.next;
        }
        if (hasLoop) {
            System.out.println("List has loop");
        }
    }

    @Test
    public void findnthnode() {
        int n = 2;

        LinkedListNode linkedList = new LinkedListNode();
        linkedList.add(new Nodes("One"));
        linkedList.add(new Nodes("Two"));
        linkedList.add(new Nodes("Three"));
        linkedList.add(new Nodes("Four"));
        linkedList.add(new Nodes("Five"));
        linkedList.printList();
        Nodes current = linkedList.head.next;
        int size = 0;
        while (current != null) {
            size++;
            current=current.next;
        }
        current = linkedList.head.next;
        for (int i = 0; i < size - n; i++) {
            current = current.next;
        }
        System.out.println(n + " ele in group from last is: " + current.currentValue);

    }
    @Test
    public void deleteFromList(){

        LinkedListNode linkedList = new LinkedListNode();
        linkedList.add(new Nodes("One"));
        linkedList.add(new Nodes("Two"));
        linkedList.add(new Nodes("Three"));
        linkedList.add(new Nodes("Four"));
        linkedList.add(new Nodes("Five"));
        linkedList.printList();
        /*
        * Delete "Three"
        * */
        String delete="One";
        Nodes deletedItem = null;
        Nodes prev=linkedList.head;
        Nodes current = linkedList.head.next;
        while (current!=null){
            if(current.currentValue.equals(delete)){
                prev.next=current.next;
                deletedItem=current;
                deletedItem.next=null;
            }
            prev=current;
            current=current.next;
        }
        linkedList.printList();
        System.out.println("Deleted item: "+deletedItem.currentValue);
    }

    @Test
    public void reverseLL(){
        LinkedListNode linkedList = new LinkedListNode();
        linkedList.add(new Nodes("One"));
        linkedList.add(new Nodes("Two"));
        linkedList.add(new Nodes("Three"));
        linkedList.add(new Nodes("Four"));
        linkedList.add(new Nodes("Five"));
        linkedList.printList();
        Nodes current = linkedList.head.next;
        Nodes prev=null,next;
        while (current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        linkedList.head.next=prev;
        linkedList.printList();
    }


    class LinkedListNode {
        private  final Nodes head;
        private Nodes tail;

        public LinkedListNode() {
            this.head = new Nodes("head");
            tail = head;
        }

        public Nodes head() {
            return head;
        }

        public void add(Nodes node) {
            tail.next = node;
            tail = node;
        }

        public void printList() {
            printList(head);
        }

        public void printList(Nodes head) {
            Nodes current = head;
            String result = "";
            while (current != null) {
                result = result + current.currentValue + " -> ";
                if (current.next == null) {
                    result = result + "null";
                }
                current = current.next;
            }
            System.out.println(result);
        }
    }

    class Nodes {
        Nodes next;
        String currentValue;

        public Nodes(String head) {
            currentValue = head;
        }
    }
}
