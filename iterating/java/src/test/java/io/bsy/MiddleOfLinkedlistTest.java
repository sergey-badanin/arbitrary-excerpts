package io.bsy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.bsy.MiddleOfLinkedlist.Node;

public class MiddleOfLinkedlistTest {

    @Test
    void testMiddleOfLinkedList() {
        var givenList = buildList(new int[] { 0, 1, 2, 3, 4 });
        assertEquals(2, MiddleOfLinkedlist.middleOfLinkedList(givenList));
    }

    @Test
    void testMiddleOfLinkedList01() {
        var givenList = buildList(new int[] { -10, -5, 6, 45, 90 });
        assertEquals(6, MiddleOfLinkedlist.middleOfLinkedList(givenList));
    }

    @Test
    void testMiddleOfLinkedList02() {
        var givenList = buildList(new int[] { -10, -5, 6, -67, 45, 90 });
        assertEquals(-67, MiddleOfLinkedlist.middleOfLinkedList(givenList));
    }

    static Node<Integer> buildList(int[] given) {
        Node<Integer> head = null;

        for (int i = given.length - 1; i >= 0; i--) {
            var curr = new Node<Integer>(given[i], head);
            head = curr;
        }

        return head;
    }

    static String printList(Node<Integer> head) {
        var builder = new StringBuilder();
        while (head != null) {
            builder.append(head.val.toString()).append(" ");
            head = head.next;
        }
        return builder.toString();
    }
}
