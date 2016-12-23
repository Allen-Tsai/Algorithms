package Trees;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Administrator on 2016/12/17.
 */
public class AVLTree {

    private static BTreeNode root,parent;

    //右旋——自己变为左孩子的右孩子；左旋——自己变为右孩子的左孩子
    private static BTreeNode rightRotate(BTreeNode q){
        if(q==null || q.getLeft()==null){
            return null;
        }

        BTreeNode p=q.getLeft();
        BTreeNode b=p.getRight();

        //找到父节点
        if((parent=root)==null){
            System.out.println("not a tree!");
            return null;
        }
        while (true){
            if(parent==q || parent.getLeft()==q || parent.getRight()==q){
                break;
            }
            if(q.getValue()<parent.getValue()){
                parent=parent.getLeft();
            }else{
                parent=parent.getRight();
            }
        }
        //q要变为p（q的左孩子）的右孩子

    }
    private static void leftRotate(){

    }

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
        System.out.println("add AVLTreeNode:");
        insertNode(new BTreeNode(s.nextInt(), null, null));
        print(root);

        while (true) {
            /*
            System.out.println("update AVLTreeNode:(input two numbers)");
            updateNode(s.nextInt(), s.nextInt());
            print(root);

            System.out.println("delete AVLTreeNode:");
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
