package com.varmints.arrays;

import static com.varmints.arrays.ArrayOperations.printArray;
import static com.varmints.arrays.ArrayOperations.printMessage;

public class ArrayRotations {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        printMessage("Before");
        printArray(array);
//        leftRotate(array);
//        reverse(array);
//        leftRotate(array, 4);
        rightRotate(array);
        printMessage("After");
        printArray(array);
    }

    private static void rightRotate(int[] array) {
        int last=array[array.length-1];
        for(int i=array.length-1;i>0;i--){
            array[i]=array[i-1];
        }
        array[0]=last;
    }

    public static void leftRotate(int[] array, int d) {
        for (int i = 0; i < d; i++) {
            leftRotate(array);
        }
    }

    private static void reverse(int[] array) {
        int j = array.length - 1;
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            j--;
        }
    }

    private static void rotation() {

    }

    private static void leftRotate(int[] array) {
        int first = array[0];
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = first;
    }

}
