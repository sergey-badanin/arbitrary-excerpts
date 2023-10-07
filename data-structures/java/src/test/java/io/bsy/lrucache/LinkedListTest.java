package io.bsy.lrucache;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class LinkedListTest {

    @Test
    public void testListValuesForEmptyList() {
        var linkedList = new LinkedList<String>();

        var actual = linkedList.listValues();
        var expected = List.of();
        assertEquals(expected, actual);
    }

    @Test
    public void testListValuesForSingleValueList() {
        var linkedList = new LinkedList<String>();
        linkedList.addValueAhead("Single");

        var actual = linkedList.listValues();
        var expected = List.of("Single");
        assertEquals(expected, actual);
    }

    @Test
    public void testListValuesForMultipleValueList() {
        var linkedList = new LinkedList<String>();
        linkedList.addValueAhead("First");
        linkedList.addValueAhead("Second");

        var actual = linkedList.listValues();
        var expected = List.of("First", "Second");
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveUnitForSingleUnitList() {
        var linkedList = new LinkedList<String>();
        var unit = linkedList.addValueAhead("Single");
        linkedList.removeUnit(unit);
        unit = linkedList.addValueAhead("Double");
        linkedList.removeUnit(unit);

        var actual = linkedList.listValues();
        var expected = List.of();
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveUnitForMidUnitInList() {
        var linkedList = new LinkedList<String>();
        linkedList.addValueAhead("First");
        var toRemove = linkedList.addValueAhead("Second");
        linkedList.addValueAhead("Third");
        linkedList.removeUnit(toRemove);

        var actual = linkedList.listValues();
        var expected = List.of("First", "Third");
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveUnitForLastUnitInList() {
        var linkedList = new LinkedList<String>();
        var toRemove = linkedList.addValueAhead("First");
        linkedList.addValueAhead("Second");
        linkedList.addValueAhead("Third");
        linkedList.removeUnit(toRemove);

        var actual = linkedList.listValues();
        var expected = List.of("Second", "Third");
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveUnitForFirstUnitInList() {
        var linkedList = new LinkedList<String>();
        linkedList.addValueAhead("First");
        linkedList.addValueAhead("Second");
        var toRemove = linkedList.addValueAhead("Third");
        linkedList.removeUnit(toRemove);

        var actual = linkedList.listValues();
        var expected = List.of("First", "Second");
        assertEquals(expected, actual);
    }

    @Test
    public void testMixOfOperations() {
        var linkedList = new LinkedList<String>();
        var first = linkedList.addValueAhead("First");
        var second = linkedList.addValueAhead("Second");
        var third = linkedList.addValueAhead("Third"); // [First, Second, Third]

        linkedList.removeUnit(second);
        linkedList.addUnitAhead(second); // [First, Third, Second]

        linkedList.removeUnit(third);
        linkedList.addUnitAhead(third); // [First, Second, Third]

        linkedList.removeUnit(first);
        linkedList.addUnitAhead(first); // [Second, Third, First]

        var actual = linkedList.listValues();
        var expected = List.of("Second", "Third", "First");
        assertEquals(expected, actual);
    }
}
