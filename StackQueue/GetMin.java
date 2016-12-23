package StackQueue;

import java.util.Random;
import java.util.Stack;

/**
 * Created by Administrator on 2016/12/15.
 */
public class GetMin {
    private static Stack<Integer> stack;
    private static final int LENGTH=20;
    private static void push(Integer a) {
        stack.push(a);
    }

    private static Integer pop() {
        if (stack.isEmpty()) {
            return null;
        }
        return stack.pop();
    }

    private static Integer getMin() {
        Integer min;
        if (stack.isEmpty()) {
            return null;
        }
        min = stack.get(0);
        for (Integer i : stack) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

    private static void print() {
        int count = 0;
        for (Integer i : stack) {
            System.out.printf("%4d\t", i);
            if (++count % 20 == 0) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        stack = new Stack<>();
        Random rm = new Random();
        for (int i = 0; i < LENGTH; i++) {
            push(rm.nextInt(100) + 1);
        }
        print();
        System.out.println("pop:" + pop());
        System.out.println("getMin:" + getMin());
        print();
    }
}
