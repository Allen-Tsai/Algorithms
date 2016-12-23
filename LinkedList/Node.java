package LinkedList;

import java.util.Collection;

/**
 * Created by Administrator on 2016/12/15.
 * ½ÚµãÀà
 */
public class Node<T> {
    private T value;
    private Node<T> next, previous;

    Node() {
        this.next = null;
        this.previous = null;
    }

    Node(T value, Node<T> previous, Node<T> next) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

    public T getValue() {

        return value;
    }

    public void setValue(T value) {

        this.value = value;
    }

    public Node<T> getNext() {

        return next;
    }

    public void setNext(Node<T> next) {

        this.next = next;
    }

    public Node<T> getPrevious() {

        return previous;
    }

    public void setPrevious(Node<T> previous) {

        this.previous = previous;
    }

}
