package io.bsy.dp;

import java.util.ArrayList;
import java.util.List;

public class TriangleMinPathSum {

    public static int solve(List<List<Integer>> triangle) {

        var sumTriangle = new ArrayList<List<Integer>>();
        for (var row : triangle) {
            var newRow = new ArrayList<Integer>();
            sumTriangle.add(newRow);
            for (var itm : row) {
                newRow.add(itm);
            }
        }

        for (int rowIdx = sumTriangle.size() - 2; rowIdx >= 0; rowIdx--) {
            var row = sumTriangle.get(rowIdx);
            var belowRow = sumTriangle.get(rowIdx + 1);

            for (int colIdx = 0; colIdx < row.size(); colIdx++) {
                var min = Math.min(belowRow.get(colIdx), belowRow.get(colIdx + 1));
                row.set(colIdx, row.get(colIdx) + min);
            }
        }

        return sumTriangle.get(0).get(0);
    }
}
