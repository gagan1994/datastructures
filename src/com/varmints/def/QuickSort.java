package com.varmints.def;

import org.junit.Test;

import java.util.Random;

public class QuickSort {

    public void mainTest() {
        int[] array = new int[10];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        System.out.println("Array list before: ");
        printArray(array);
        quickSort(0, array.length - 1, array);
        System.out.println("Array list after: ");
        printArray(array);
    }

    private void quickSort(int low, int high, int[] array) {
        if (low < high) {
            int piviot = partition(low, high, array);
            quickSort(piviot + 1, high, array);
            quickSort(low, piviot - 1, array);
        }
    }

    private int partition(int low, int high, int[] array) {
        int pi = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] < pi) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
