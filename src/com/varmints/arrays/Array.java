package com.varmints.arrays;

import java.util.HashMap;

public class Array {
    int[] arr;

    public Array(int size) {
        arr = new int[size];
    }

    public void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void insert(int number) {
        if (arr[arr.length - 1] == 0) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    arr[i] = number;
                    break;
                }
            }
        } else {
            int[] temp = arr;
            arr = new int[temp.length + 1];
            for (int i = 0; i < temp.length; i++) {
                arr[i] = temp[i];
            }
            arr[temp.length] = number;
        }
    }

    public void removeAt(int index) {
        int[] temp = arr;
        if (temp.length > index) {
            arr = new int[temp.length - 1];
            for (int i = 0; i < temp.length - 1; i++) {
                if (i >= index) {
                    arr[i] = temp[i + 1];
                } else if (i < index) {
                    arr[i] = temp[i];
                }
            }
        }
    }

    public int indexOf(int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num)
                return i;
        }
        return -1;
    }
}
