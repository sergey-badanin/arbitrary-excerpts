package io.bsy;

public class MiddleOfLinkedlist {

    public static int middleOfLinkedList(Node<Integer> head) {
        int currIndex = 0;
        var middleNode = head;

        while (head != null) {
            head = head.next;
            if (currIndex % 2 == 1) {
                middleNode = middleNode.next;
            }
            currIndex++;
        }

        return middleNode.val;
    }

    public static class Node<T> {
        public T val;
        public Node<T> next;

        public Node(T val) {
            this(val, null);
        }

        public Node(T val, Node<T> next) {
            this.val = val;
            this.next = next;
        }
    }
}
