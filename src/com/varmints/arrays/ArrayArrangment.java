package com.varmints.arrays;

import static com.varmints.arrays.ArrayOperations.printArray;
import static com.varmints.arrays.ArrayOperations.swapArr;

public class ArrayArrangment {
    public static void main(String[] args) {
//        rearrangPositiveAndNegativeNumbers();
//        rearrangEvenAndOdd();
        replaceAjMul();
    }

    private static void replaceAjMul() {
        int[] arr = new int[]{2, 3, 4, 5, 6};
        int[] resArr=new int[arr.length];
        printArray(arr);
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                resArr[i] = arr[i] * arr[i + 1];
                continue;
            }
            if (i == arr.length - 1) {
                resArr[i] = arr[i] * arr[i - 1];
                continue;
            }
            resArr[i] = arr[i + 1] * arr[i - 1];
        }
        printArray(resArr);
    }

    private static void rearrangEvenAndOdd() {
        int[] arr = new int[]{-1, 2, -3, 4, 5, 6, -7, 8, 9};
        printArray(arr);
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                swapArr(arr, i, k);
                k++;
            }
        }
        printArray(arr);
    }

    private static void rearrangPositiveAndNegativeNumbers() {
        int[] arr = new int[]{-1, 2, -3, 4, 5, 6, -7, 8, 9};
        printArray(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    swapArr(arr, i, j);
                }
            }
        }
        printArray(arr);
    }
}
