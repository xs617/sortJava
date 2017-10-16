package structure;

import java.util.LinkedList;

public class LinkList<T> {
    private Node<T> head = new Node<T>(null);
    private Node<T> tail = head;

    public T getHeadValue() {
        if (head.next != null) {
            return head.next.data;
        }
        return null;
    }

    public T getTailValue() {
        if (tail != null) {
            return tail.data;
        }
        return null;
    }

    public Node<T> getHeadNode() {
        return head;
    }

    public Node<T> getTailNode() {
        return tail;
    }

    public void addFront(T data) {
        Node<T> node = new Node<T>(data);
        node.next = head.next;
        node.prev = head.prev;
        head.next = node;
        if (head == tail) {
            tail = node;
        }
    }

    public void addTail(T data) {
        Node<T> node = new Node<T>(data);
        node.prev = tail;
        tail.next = node;
    }

    public void linkBefore(T data, Node<T> targetNode) {
        Node<T> node = new Node<T>(data);
        node.prev = targetNode.prev;
        node.next = targetNode;
    }

    public void linkAfter(T data, Node<T> targetNode) {
        Node<T> node = new Node<T>(data);
        node.next = targetNode.next;
        node.prev = targetNode;
        targetNode.next = node;
    }

    public class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

}
