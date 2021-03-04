package com.varmints.trees;


import static com.varmints.def.QuickSort.printArray;

public class BinarySearch {

    public void testBinarySearch() {
        int[] array = new int[]{1, 2, 4, 6, 8, 10, 10, 22, 35};
        System.out.println("Array list before: ");
        printArray(array);
        search(10, array);
    }


    public void search(int item, int[] array) {
        int r = array.length;
        int l = 0;
        int foundAt = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (array[mid] == item) {
                foundAt = mid;
            }
            if (array[mid] > item) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (foundAt != -1) {
            System.out.println("item: " + item + " found At: " + foundAt);
        } else {
            System.out.println("item not in the list");
        }

    }

    public void secondMax() {
        int[] arr = new int[]{1, 4, 55, 2, 5, 9, 56};
        int max2=0;
        int max1=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max1) {
                max2 = max1;
                max1 = arr[i];
            } else {
                if (arr[i] > max2) {
                    max2 = arr[i];
                }
            }
        }
        System.out.println("max:"+max1+" max2 "+max2);
        }
    }
