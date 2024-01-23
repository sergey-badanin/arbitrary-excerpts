package io.bsy.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SequenceReconstruction {

    public static boolean sequenceReconstruction(List<Integer> original, List<List<Integer>> seqs) {
        var graph = buildGraph(original, seqs);
        var incDegrees = buildIncDegrees(original, graph);

        var queue = new LinkedList<Integer>();
        var order = new LinkedList<Integer>();

        for (var inc : incDegrees.entrySet()) {
            if (inc.getValue() == 0) {
                queue.addLast(inc.getKey());
            }
        }

        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                return false;
            }
            var curr = queue.removeFirst();
            order.addLast(curr);

            incDegrees.remove(curr);
            for (var inc : graph.get(curr)) {
                incDegrees.merge(inc, 1, (l, r) -> l - r);
            }

            for (var inc : incDegrees.entrySet()) {
                if (inc.getValue() == 0) {
                    queue.addLast(inc.getKey());
                }
            }
        }

        return original.equals(order);
    }

    private static Map<Integer, Set<Integer>> buildGraph(List<Integer> original, List<List<Integer>> seqs) {
        var graph = new HashMap<Integer, Set<Integer>>();

        for (var i : original) {
            graph.put(i, new HashSet<>());
        }

        for (var seq : seqs) {
            for (int i = 0; i < seq.size() - 1; i++) {
                graph.get(seq.get(i)).add(seq.get(i + 1));
            }
        }

        return graph;
    }

    private static Map<Integer, Integer> buildIncDegrees(List<Integer> original, Map<Integer, Set<Integer>> graph) {
        var incDegrees = new HashMap<Integer, Integer>();

        for (var i : original) {
            incDegrees.put(i, 0);
        }
        for (var entry : graph.entrySet()) {
            for (var incNode : entry.getValue())
                incDegrees.merge(incNode, 1, (l, r) -> l + r);
        }
        return incDegrees;
    }

}
