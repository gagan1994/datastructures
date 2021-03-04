package com.varmints.arrays;

import static com.varmints.arrays.ArrayRotations.leftRotate;

public class ArrayOperations {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printArray(int[] array) {
        String val = array[0] + "";
        for (int i = 1; i < array.length; i++) {
            val = val + ", " + array[i];
        }
        printMessage(val);
    }

    public static void swapArr(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] array = new int[]{12, 22, 13, 7, 35, 61, 37, 8, 19};
//        sortArray(array);
//        binarySearch(array);
//        pairWithGivenSum(array, 20);
//        maxSumRotate(array);
//        getMinmumele(array);
        splitAandJoinEnd(array,5);
    }

    private static void splitAandJoinEnd(int[] array, int index) {
        printMessage("Before");
        printArray(array);
        leftRotate(array,index);
        printMessage("After");
        printArray(array);
    }

    private static void getMinmumele(int[] array) {
        printMessage("array is");
        printArray(array);
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        printMessage("min ele in array is: " + min);
    }

    private static void maxSumRotate(int[] array) {
        int[] resArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            leftRotate(array, i);
            resArray[i] = maxSum(array);
        }
        printMessage("maxSum is: " + getMax(resArray));
    }

    private static int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    private static int maxSum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i] * i;
        }
        return sum;
    }

    private static void pairWithGivenSum(int[] array, int sum) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (sum == (array[i] + array[j])) {
                    printMessage("pair found (" + i + ", " + j + ") is " + "(" + array[i] + ", " + array[j] + ")");
                }
            }
        }
    }

    private static void binarySearch(int[] array) {
        sortArray(array);
        int searchEle = 12;
        int ele = binarySearch(0, array.length, array, searchEle);
        if (ele == -1) {
            System.out.println("element: " + searchEle + " not found");
        } else {
            System.out.println("element: " + searchEle + " found at " + ele);
        }
    }

    private static int binarySearch(int first, int last, int[] array, int searchEle) {
        if (first > last) return -1;
        int mid = (first + last) / 2;
        if (array[mid] == searchEle) {
            return mid;
        }
        if (array[mid] < searchEle) {
            return binarySearch(mid + 1, last, array, searchEle);
        }
        if (array[mid] > searchEle) {
            return binarySearch(first, mid - 1, array, searchEle);
        }
        return -1;
    }

    private static void sortArray(int[] array) {
        printMessage("Before sort");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] < array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        printMessage("After sort");
    }
}
