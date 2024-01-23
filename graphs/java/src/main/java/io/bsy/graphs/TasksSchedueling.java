package io.bsy.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TasksSchedueling {

    public static List<String> taskScheduling(List<String> tasks, List<List<String>> requirements) {
        var graph = new HashMap<String, Set<String>>();

        for (var task : tasks) {
            graph.put(task, new HashSet<String>());
        }

        for (var dependency : requirements) {
            graph.get(dependency.get(0)).add(dependency.get(1));
        }

        return sort(graph);
    }

    public static <T> List<T> sort(Map<T, Set<T>> graph) {

        Map<T, Set<T>> inDegree = graph.keySet().stream()
                .collect(Collectors.toMap(vertex -> vertex, vertex -> new HashSet<T>()));

        for (var node : graph.entrySet()) {
            for (var vertex : node.getValue()) {
                inDegree.get(vertex).add(node.getKey());
            }
        }

        var queue = new LinkedList<T>();
        var result = new LinkedList<T>();

        for (var node : inDegree.entrySet()) {
            if (node.getValue().size() == 0) {
                queue.addLast(node.getKey());

            }
        }

        while (!queue.isEmpty()) {

            while (!queue.isEmpty()) {
                var vertex = queue.removeFirst();
                inDegree.remove(vertex);

                for (var connected : graph.get(vertex)) {
                    inDegree.get(connected).remove(vertex);
                }
                graph.remove(vertex);
                result.addLast(vertex);
            }

            for (var node : inDegree.entrySet()) {
                if (node.getValue().size() == 0) {
                    queue.addLast(node.getKey());
                }
            }
        }

        return result;
    }
}
