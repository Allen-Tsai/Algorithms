package Trees;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Administrator on 2016/12/16.
 */
public class BinaryTree {
    private static BTreeNode root, parent;

    /*
        private static void crash() {
            System.out.println("FUCK! SYSTEM HAS A LOGICAL ERROR!!");
            System.exit(1);
        }
    */
    private static void insertNode(BTreeNode a) {
        if (root == null) {
            root = a;
            return;
        }
        parent = root;
        //先走到叶子节点
        while (parent != null) {
            if ((a.getValue() < parent.getValue()) && (parent.getLeft() != null)) {
                //左子节点还有元素
                parent = parent.getLeft();
            } else if ((a.getValue() >= parent.getValue()) && (parent.getRight() != null)) {
                //右子节点还有元素
                parent = parent.getRight();
            } else if (a.getValue() < parent.getValue()) {
                parent.setLeft(a);
                break;
            } else {
                parent.setRight(a);
                break;
            }
        }
    }

    private static void createBTree() {
        Random rm = new Random();
        System.out.println("create a BinaryTree contains 10 nodes...");
        int length = 0;
        do {
            insertNode(new BTreeNode(rm.nextInt(100) + 1, null, null));
        } while (++length < 10);
        System.out.println("done.");
    }

    private static void updateNode(int a, int b) {
        if (deleteNode(a, root) == null) {
            System.out.println("haven't found!");
            return;
        }
        insertNode(new BTreeNode(b, null, null));
    }

    private static BTreeNode findMax(BTreeNode node) {
        if (node == null)
            return null;
        else if (node.getRight() == null)
            return node;
        return findMax(node.getRight());
    }

    private static BTreeNode findMin(BTreeNode node) {
        if (node == null)
            return null;
        else if (node.getLeft() == null)
            return node;
        return findMin(node.getLeft());
    }


    private static BTreeNode deleteNode(int t, BTreeNode node) {
        if (node == null)
            return null;//没有找到,doNothing
        if (t > node.getValue())
            node.setRight(deleteNode(t, node.getRight()));
        else if (t < node.getValue())
            node.setLeft(deleteNode(t, node.getLeft()));
        else if (node.getLeft() != null && node.getRight() != null) {
            node.setValue(findMin(node.getRight()).getValue());
            node.setRight(deleteNode(node.getValue(), node.getRight()));
        } else
            node = (node.getLeft() != null) ? node.getLeft() : node.getRight();
        return node;
    }

    private static BTreeNode find(int t, BTreeNode a) {
        if (a == null) {
            return null;
        }
        if (t < a.getValue()) {
            return find(t, a.getLeft());
        } else if (t > a.getValue()) {
            return find(t, a.getRight());
        } else {
            return a;
        }
    }

    private static void print(BTreeNode bt) {
        if (bt == root) {
            System.out.println("print BinaryTree Nodes:");
        }
        if (bt != null) {
            System.out.printf("%4d\t", bt.getValue());
            print(bt.getLeft());
            print(bt.getRight());
            if (bt.getRight() == null && bt.getLeft() == null) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        createBTree();
        print(root);
        System.out.println("add BTreeNode:");
        insertNode(new BTreeNode(s.nextInt(), null, null));
        print(root);

        while (true) {
            /*
            System.out.println("update BTreeNode:(input two numbers)");
            updateNode(s.nextInt(), s.nextInt());
            print(root);

            System.out.println("delete BTreeNode:");
            deleteNode(s.nextInt(), root);
            print(root);
            */
            System.out.println("find:");
            if (find(s.nextInt(),root) == null) {
                System.out.println("haven't found!");
            } else {
                System.out.println("have found it!");
            }
        }

    }
}
