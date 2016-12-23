package StackQueue;

import java.util.Random;
import java.util.Stack;

/**
 * Created by Administrator on 2016/12/15.
 */
public class StackToQueue {
    private static Stack<Integer> stackPush=new Stack<>();
    private static Stack<Integer> stackPop=new Stack<>();
    private static final int LENGTH=20;

    private static void connectStacks(){
        if(stackPush.isEmpty()){
            return;
        }
        stackPop.clear();
        for(Integer a:stackPush ){
            stackPop.push(a);
        }
    }

    private static void add(int a){
        stackPush.push(a);
    }

    private static Integer peek(){
        if(stackPush.isEmpty()||stackPop.isEmpty()){
            return null;
        }
        return stackPush.firstElement();
    }

    private static Integer poll(){
        if(stackPush.isEmpty()||stackPop.isEmpty()){
            return null;
        }
        stackPush.removeElementAt(0);
        connectStacks();
        return stackPop.firstElement();
    }

    private static void print() {
        int count = 0;
        for (Integer i : stackPop) {
            System.out.printf("%4d\t", i);
            if (++count % 20 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Random rm = new Random();
        for (int i = 0; i < LENGTH; i++) {
            add(rm.nextInt(100) + 1);
        }
        connectStacks();
        print();
        System.out.println("peek:"+peek());
        System.out.println("poll:"+poll());
        print();
    }

}
