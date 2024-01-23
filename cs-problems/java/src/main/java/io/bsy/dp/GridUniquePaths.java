package io.bsy.dp;

import java.util.ArrayList;
import java.util.List;

/*
 * Count number of unique path from top-right cell to the bottom left 
 * Aloowed moves: right and downwards
 */
public class GridUniquePaths {

    public static int solve(int m, int n) {
        var known = new Integer[m][n];

        return calculateForCell(m, n, 0, 0, known);
    }

    static int calculateForCell(int rows, int cols, int row, int col, Integer[][] known) {
        var transitions = findAllowedTransitions(rows, cols, row, col);

        if (transitions.isEmpty()) {
            return 1;
        }

        var totalCount = 0;
        for (var transition : transitions) {
            if (known[transition[0]][transition[1]] == null) {
                known[transition[0]][transition[1]] = calculateForCell(rows, cols, transition[0], transition[1], known);
            }
            totalCount += known[transition[0]][transition[1]];
        }

        return totalCount;
    }

    static List<int[]> findAllowedTransitions(int rows, int cols, int row, int col) {
        var result = new ArrayList<int[]>();
        if (row < rows - 1) {
            result.add(new int[] { row + 1, col });
        }
        if (col < cols - 1) {
            result.add(new int[] { row, col + 1 });
        }
        return result;
    }
}
