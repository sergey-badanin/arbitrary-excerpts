package io.bsy.dp;

import java.util.ArrayList;
import java.util.List;

public class MinPathSum {

    public static int solve(List<List<Integer>> grid) {
        var rows = grid.size();
        var cols = grid.get(0).size();

        var optimalPaths = new int[rows][cols];

        for (int row = rows - 1; row >= 0; row--) {
            for (int col = cols - 1; col >= 0; col--) {
                var transitions = findAllowedTransitions(rows, cols, row, col);
                if (transitions.isEmpty()) {
                    optimalPaths[row][col] = grid.get(row).get(col);
                    continue;
                }
                var minRoute = transitions.stream().map(a -> optimalPaths[a[0]][a[1]])
                        .min((a, b) -> Integer.compare(a, b)).get();
                optimalPaths[row][col] = grid.get(row).get(col) + minRoute;
            }
        }

        return optimalPaths[0][0];
    }

    private static List<int[]> findAllowedTransitions(int rows, int cols, int row, int col) {
        var transitions = new ArrayList<int[]>();
        if (row < rows - 1) {
            transitions.add(new int[] { row + 1, col });
        }
        if (col < cols - 1) {
            transitions.add(new int[] { row, col + 1 });
        }
        return transitions;
    }
}
