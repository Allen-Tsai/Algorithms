package Trees;

/**
 * Created by Administrator on 2016/12/16.
 */
public class BTreeNode {
    private int value;
    private BTreeNode left, right;

    BTreeNode(){}

    BTreeNode(int value, BTreeNode left, BTreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BTreeNode getLeft() {
        return left;
    }

    public void setLeft(BTreeNode left) {
        this.left = left;
    }

    public BTreeNode getRight() {
        return right;
    }

    public void setRight(BTreeNode right) {
        this.right = right;
    }
}
