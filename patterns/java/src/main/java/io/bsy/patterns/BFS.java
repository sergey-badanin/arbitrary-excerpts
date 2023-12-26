package io.bsy.patterns;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BFS {

    public static void graphBfs(List<List<Vertex>> graph) {

        var queue = new LinkedList<Vertex>();
        var visited = new HashSet<Vertex>();

        var starting = getStarting(graph);

        queue.addLast(starting);
        visited.add(starting);

        while (!queue.isEmpty()) {
            var current = queue.removeFirst();
            var connected = getConnected(graph, current);
            for (var neighbor : connected) {
                if (!visited.contains(neighbor)) {
                    queue.addLast(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }

    private static Set<Vertex> getConnected(List<List<Vertex>> graph, Vertex vertex) {
        return Collections.emptySet();
    }

    private static Vertex getStarting(List<List<Vertex>> graph) {
        return new Vertex();
    }

    public static class Vertex {

        public int row;
        public int col;
    }
}
