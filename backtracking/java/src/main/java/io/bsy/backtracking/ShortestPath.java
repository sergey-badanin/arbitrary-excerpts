package io.bsy.backtracking;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ShortestPath {

    public int shortestPath(List<List<Integer>> graph, int a, int b) {

        var queue = new LinkedList<Integer>();
        queue.addLast(a);
        var visited = new HashSet<Integer>();
        visited.add(a);

        var level = 0;
        while (!queue.isEmpty()) {
            var previousLevelSize = queue.size();

            for (int i = 0; i < previousLevelSize; i++) {
                var current = queue.removeFirst();
                if (current == b) {
                    return level;
                }
                var neiqhbors = graph.get(current);
                for (int neightbor : neiqhbors) {
                    if (visited.contains(neightbor)) {
                        continue;
                    }
                    queue.addLast(neightbor);
                    visited.add(neightbor);
                }
            }
            level += 1;
        }
        return -1;
    }
}
