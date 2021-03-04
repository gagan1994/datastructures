package com.varmints.practice;

import java.util.*;

public class MainClass {
    public static void main(String[] args) {
//        int[] arr = new int[]arr{10, 20, 20, 10, 10, 30, 50, 10, 20};
//        int res = sockMerchant(arr.length, arr);
//        System.out.println("Pairs are: " + res);
//        String path = "UDDDUDUU";
//        int steps = 8;
//        System.out.println("cuntingVally are: " + countingValleys(steps, path));
//        int[] clouds = new int[]{0, 0, 1, 0, 0, 0, 0, 1, 0, 0};
//        System.out.println("Jumping on clouds: " + jumpingOnClouds(clouds));

//        System.out.println("Decrytp: "+decrypt("51Pa*0Lp*0e"));
//        printThePattern(3);
//        ArrayList<Integer> before = new ArrayList<Integer>(Arrays.asList(4, 73, 67, 38, 33));
//        System.out.println("Before : " + print(before));
//        System.out.println("After : " + print(gradingStudents(before)));
    }
    static String kangaroo(int x1, int v1, int x2, int v2) {
        if(x2>x1&&v2>v1)return "NO";
        return (((x1-x2)%(v2-v1))==0)? "YES":"NO";


    }
    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {

        int applesOnHouse = 0;
        for (int i = 0; i < apples.length; i++) {
            int posOfApple = apples[i] + a;
            if (posOfApple >= s && posOfApple <= t) {
                applesOnHouse++;
            }
        }
        int orangesOnHouse = 0;
        for (int i = 0; i < oranges.length; i++) {
            int posOfOrrange = oranges[i] + b;
            if (posOfOrrange >= s && posOfOrrange <= t) {
                orangesOnHouse++;
            }
        }
        System.out.println("Apples: " + applesOnHouse);
        System.out.println("Oranges: " + orangesOnHouse);
    }

    private static String print(List<Integer> before) {
        String ret = "";
        for (Integer integer : before) {
            ret = ret + integer + " ";
        }
        return ret;
    }

    private static void printThePattern(int n) {
        int emptySpace = n - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < emptySpace; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++)
                System.out.print("* ");
            System.out.println("\n");
            emptySpace--;
        }

    }

    private static String rev(char[] strAsByteArray) {
        char[] result = new char[strAsByteArray.length];
        for (int i = 0; i < strAsByteArray.length; i++)
            result[i] = strAsByteArray[strAsByteArray.length - i - 1];

        return (new String(result));
    }

    static int sockMerchant(int n, int[] ar) {
        HashMap<Integer, Integer> hashmap = new HashMap();
        int[] arr = Arrays.copyOf(ar, ar.length);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    if (hashmap.containsKey(arr[i])) {
                        Integer val = hashmap.get(arr[i]);
                        hashmap.put(arr[i], val + 1);
                    } else {
                        hashmap.put(arr[i], 1);
                    }
                    arr[j] = -1;
                }

            }
        }
        int count = 0;
        for (Integer keys : hashmap.keySet()) {
            count = count + hashmap.get(keys) / 2;
        }
        return count;
    }

    public static int countingValleys(int steps, String path) {
        int vally = 0;
        char[] pathArray = path.toCharArray();
        int vallyStack = 0;
        for (int i = 0; i < path.length(); i++) {
            if (pathArray[i] == 'U') {
                if (++vallyStack == 0) {
                    vally = vally + 1;
                }
            } else {
                vallyStack--;
            }

        }
        return vally;
    }

    static int jumpingOnClouds(int[] c) {
        int count = 0;
        for (int i = 0; i < c.length - 1; i++) {
            if (c[i] == 0) i++;
            count++;
        }
        return count;
    }

    static String decrypt(String s) {
        char[] passwordChar = s.toCharArray();
        for (int i = 0; i < passwordChar.length; i++) {
            char value = passwordChar[i];
            boolean isDigit = Character.isDigit(value);
            if (isDigit) {
                for (int j = passwordChar.length - 1; j >= i; j--) {
                    if (passwordChar[j] == '0') {
                        int temp = passwordChar[i];
                        passwordChar[j] = passwordChar[i];
                        passwordChar[i] = ' ';
                        break;
                    }
                }
            } else {
                if (Character.isUpperCase(value)) {
                    if (i < passwordChar.length - 2) {
                        if (passwordChar[i + 2] == '*') {
                            char temp = passwordChar[i];
                            passwordChar[i] = passwordChar[i + 1];
                            passwordChar[i + 1] = temp;
                            passwordChar[i + 2] = ' ';
                            i = i + 2;
                        }
                    }
                }
            }
        }
        String retString = new String(passwordChar);
        retString = retString.replaceAll(" ", "");
        return retString;
    }

    public static List<Integer> gradingStudents(List<Integer> grades) {
//If the difference between the grade and the next multiple of  5 is less than 3, round  up to the next multiple of .
//If the value of  is less than , no rounding occurs as the result will still be a failing grade.
        for (int i = 0; i < grades.size(); i++) {
            Integer grade = grades.get(i);
            if (grade >= 38) {
                int rem = grade % 5;
                if (rem >= 3) {
                    grade = grade - rem + 5;
                    grades.remove(i);
                    grades.add(i, grade);
                }

            }
        }
        return grades;
    }
}
