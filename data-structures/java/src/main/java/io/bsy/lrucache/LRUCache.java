package io.bsy.lrucache;

import java.util.HashMap;
import java.util.Map;

import io.bsy.lrucache.LinkedList.ListUnit;

public class LRUCache<K, V> {

    private final HashMap<K, ListUnit<KeyVal<K,V>>> map;
    private final LinkedList<KeyVal<K,V>> tracker;
    private final int capacity;

    public LRUCache(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        map = new HashMap<>(capacity);
        tracker = new LinkedList<>();
        this.capacity = capacity;
    }

    public V get(K key) {
        var unit = map.get(key);
        if (unit != null) {
            unit = tracker.swapHead(unit);
        }
        return unit == null ? null : unit.getValue().value();
    }

    public void put(K key, V value) {
        var unit = map.get(key);
        if (unit != null) {
            var entry = new KeyVal<>(key, value);
            unit.setValue(entry);
            unit = tracker.swapHead(unit);
            return;
        }
        if (map.size() == capacity) {
            var tail = tracker.removeTail();
            map.remove(tail.getValue().key());
        } 
        unit = tracker.addValueAhead(new KeyVal<>(key, value));
        map.put(key, unit);
    }

    record KeyVal<K, V>(K key, V value){};
}
