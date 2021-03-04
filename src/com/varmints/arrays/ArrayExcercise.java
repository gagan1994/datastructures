package com.varmints.arrays;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class ArrayExcercise {
    public static void main(String[] args) {
        Array array = new Array(3);
        array.insert(1);
        array.insert(2);
        array.insert(3);
        array.insert(4);
        LinkedList a = new LinkedList();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        System.out.println("index: " + array.indexOf(2));

    }
}
