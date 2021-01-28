package com.tarams.algorithmanddesignpattern;

import org.junit.Test;

import java.util.Stack;

public class StackOperations {
    @Test
    public void reverseStringUsingStack() {
        String str = "asdfghjkl";
        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            stack.push(chars[i]);
        }
        String rev = "";
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            rev = rev + stack.pop();
        }
        System.out.println("original: " + str);
        System.out.println("reversed: " + rev);
    }

    @Test
    public void balancedParanthsis() {
        String input="[()]{}{[()()]()}";
//        String input = "[(])";
        char[] chars = input.toCharArray();
        Stack stack = new Stack();
        for (int i = 0; i < chars.length; i++) {
            char x = chars[i];
            if (x == '{' || x == '[' || x == '(') {
                stack.push(chars[i]);
                continue;
            }
            assert !stack.isEmpty();
            switch (x) {
                case ')':
                    if (stack.get(stack.size()-1).equals('(')) {
                        stack.pop();
                    }
                    break;
                case '}':
                    if (stack.get(stack.size()-1).equals('{')) {
                        stack.pop();
                    }
                    break;
                case ']':
                    if (stack.get(stack.size()-1).equals('[')) {
                        stack.pop();
                    }
                    break;
            }

        }
        assert stack.isEmpty();
    }
}
