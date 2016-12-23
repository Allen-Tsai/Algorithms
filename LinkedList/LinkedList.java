package LinkedList;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Administrator on 2016/12/15.
 * 链表类:双向循环链表
 */

public class LinkedList {

    private static Node<Integer> head, temp;

    private static void createList() {
        Random rm = new Random();
        System.out.println("create a linkedList contains 10 nodes...");
        for (int i = 0; i < 10; i++) {
            insertNode(rm.nextInt(100) + 1);
        }
        System.out.println("Done.");
    }

    private static boolean isEmpty(Node n) {
        return n == null;
    }

    private static void insertNode(int a) {
        //如果是空链表
        if (head == null) {
            head = new Node(a, null, null);
        } else if (head.getNext() == null || head.getPrevious() == null) {
            Node t = new Node(a, head, head);
            head.setNext(t);
            head.setPrevious(t);
        } else {
            temp = head;
            //找到表尾
            while (temp.getNext() != head) {
                temp = temp.getNext();
            }
            Node t = new Node(a, temp, head);
            temp.setNext(t);
            head.setPrevious(t);
        }
    }

    private static void deleteNode(int a) {
        temp = find(a);
        if (isEmpty(temp)) {
            System.out.println("can't find the node to delete!");
            return;
        }
        if (temp == head) {
            head = temp.getNext();
        }
        temp.getPrevious().setNext(temp.getNext());
        temp.getNext().setPrevious(temp.getPrevious());
    }

    private static void change(int a, int b) {
        temp = find(a);
        if (isEmpty(temp)) {
            System.out.println("can't find the node to change!");
            return;
        }
        temp.setValue(b);
    }

    private static Node find(int a) {
        temp = head;
        do {
            temp = temp.getNext();
            if (a == temp.getValue()) {
                return temp;
            }
        } while (temp != head);
        return null;
    }

    private static void print() {
        int i = 0;
        temp = head;
        do {
            System.out.printf("%4d\t", temp.getValue());
            temp = temp.getNext();
            if (++i % 10 == 0) {
                System.out.println();
            }
        } while (temp != head);
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        createList();
        System.out.println("original list:");
        print();
        //增
        System.out.println("please input a number to insert:");
        insertNode(s.nextInt());
        print();
        //删
        System.out.println("please input a number to delete:");
        deleteNode(s.nextInt());
        print();
        //改
        System.out.println("please input two numbers:A changes to B:");
        change(s.nextInt(), s.nextInt());
        print();

        //查
        System.out.println("please input a number to find:");
        if (!isEmpty(find(s.nextInt()))) {
            System.out.println("have found!");
        }
    }
}
