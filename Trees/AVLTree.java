package Trees;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Administrator on 2016/12/17.
 */
public class AVLTree {

    private static BTreeNode root,parent;

    //���������Լ���Ϊ���ӵ��Һ��ӣ����������Լ���Ϊ�Һ��ӵ�����
    private static BTreeNode rightRotate(BTreeNode q){
        if(q==null || q.getLeft()==null){
            return null;
        }

        BTreeNode p=q.getLeft();
        BTreeNode b=p.getRight();

        //�ҵ����ڵ�
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
        //qҪ��Ϊp��q�����ӣ����Һ���

    }
    private static void leftRotate(){

    }

    private static void insertNode(BTreeNode a) {
        if (root == null) {
            root = a;
            return;
        }
        parent = root;
        //���ߵ�Ҷ�ӽڵ�
        while (parent != null) {
            if ((a.getValue() < parent.getValue()) && (parent.getLeft() != null)) {
                //���ӽڵ㻹��Ԫ��
                parent = parent.getLeft();
            } else if ((a.getValue() >= parent.getValue()) && (parent.getRight() != null)) {
                //���ӽڵ㻹��Ԫ��
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
