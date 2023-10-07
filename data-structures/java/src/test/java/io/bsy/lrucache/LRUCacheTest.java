package io.bsy.lrucache;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class LRUCacheTest {

    @Test
    public void testEdgeCaseSingleUnitCache() {
        var cache = new LRUCache<Integer, String>(1);
        cache.put(1, "One");
        cache.put(2, "Two");

        assertNull(cache.get(1));
    }

    @Test
    public void testMultipleUnitsCache() {
        var cache = new LRUCache<Integer, String>(3);
        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");
        cache.put(1, "One-1");
        cache.put(4, "Four");

        assertNull(cache.get(2));
    }
}
