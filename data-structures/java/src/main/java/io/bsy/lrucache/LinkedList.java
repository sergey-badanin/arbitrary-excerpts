package io.bsy.lrucache;

import java.util.ArrayList;
import java.util.List;

class LinkedList<T> {
    private ListUnit<T> head;
    private ListUnit<T> tail;
    private int size = 0;

    public ListUnit<T> addValueAhead(T value) {
        var newHead = new ListUnit<>(value);
        return addUnitAhead(newHead);
    }

    public ListUnit<T> addUnitAhead(ListUnit<T> newHead) {
        size += 1;
        if (head == null) {
            head = newHead;
            head.next = null;
            head.prev = null;
            tail = head;
        } else {
            head.next = newHead;
            newHead.prev = head;
            head = newHead;
            newHead.next = null;
        }
        return head;
    }

    public ListUnit<T> removeTail() {
        return removeUnit(tail);
    }

    public ListUnit<T> removeUnit(ListUnit<T> unit) {
        if (unit.prev == null && unit.next == null) {
            head = null;
            tail = null;
        } else if (unit.prev == null) {
            unit.next.prev = null;
            tail = unit.next;
        } else if (unit.next == null) {
            unit.prev.next = null;
            head = unit.prev;
        } else {
            unit.prev.next = unit.next;
            unit.next.prev = unit.prev;
        }
        unit.next = unit.prev = null;
        size -= 1;
        return unit;
    }

    public ListUnit<T> swapHead(ListUnit<T> unit) {
        return addUnitAhead(removeUnit(unit));
    }

    public List<T> listValues() {
        var result = new ArrayList<T>(size);

        var curr = tail;
        while (curr != null) {
            result.add(curr.value);
            curr = curr.next;
        }
        return result;
    }

    /*
     * next is in the direction from tail to head
     * prev is in the direction from head to tail
     */
    static class ListUnit<T> {
        ListUnit<T> next;
        ListUnit<T> prev;
        private T value;

        ListUnit(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }

}
