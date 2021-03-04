package com.varmints.def;

import org.junit.Test;

public class StringOperations {

    public void removeDuplicateString() {
        String text = "hello, remove duplicate";
        char[] chars = text.toCharArray();
        String result = "";
        for (int i = 0; i < chars.length; i++) {
            int j = 0;
            for (j = 0; j < i; j++) {
                if (chars[i] == chars[j]) {
                    break;
                }
            }
            if (i == j) {
                result = result + chars[i];
            }
        }
        System.out.println("Original: "+text);
        System.out.println("after removing duplicate: "+result);
    }
}
