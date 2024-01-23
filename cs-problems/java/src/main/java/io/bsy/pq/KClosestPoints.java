package io.bsy.pq;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPoints {

    public static List<List<Integer>> solve(List<List<Integer>> points, int k) {
        Comparator<List<Integer>> pointComparator = (a, b) -> {
            var aDist = (a.get(0)) * (a.get(0)) + (a.get(1)) * (a.get(1));
            var bDist = (b.get(0)) * (b.get(0)) + (b.get(1)) * (b.get(1));
            return Integer.compare(aDist, bDist);
        };

        var pq = new PriorityQueue<List<Integer>>(points.size(), pointComparator);

        for (var point : points) {
            pq.add(point);
        }

        var result = new ArrayList<List<Integer>>();
        for (int i = 0; i < k; i++) {
            result.add(pq.poll());
        }

        return result;
    }

}
