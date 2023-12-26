package io.bsy.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class NumberOfIslands {

    public static int countNumberOfIslands(List<List<Integer>> grid) {

        var lands = new HashSet<Cell>();
        var islandsCount = 0;
        for (int row = 0; row < grid.size(); row++) {
            for (int col = 0; col < grid.get(0).size(); col++) {
                var tile = Cell.of(row, col);
                if (isLand(grid, tile) && !lands.contains(tile)) {
                    islandsCount++;
                    exploreIsland(lands, tile, grid);
                }
            }
        }
        return islandsCount;
    }

    private static void exploreIsland(HashSet<Cell> lands, Cell landPiece, List<List<Integer>> grid) {
        var queue = new LinkedList<Cell>();
        queue.addLast(landPiece);
        lands.add(landPiece);
        while (!queue.isEmpty()) {
            var tile = queue.removeFirst();
            var connectedTiles = getConnected(grid, tile);

            for (var one : connectedTiles) {
                if (!lands.contains(one)) {
                    queue.addLast(one);
                    lands.add(one);
                }
            }
        }
    }

    private static boolean isLand(List<List<Integer>> grid, Cell cell) {
        return grid.get(cell.r).get(cell.c) == 1;
    }

    private static List<Cell> getConnected(List<List<Integer>> grid, Cell cell) {
        var connected = new ArrayList<Cell>();

        if (cell.r > 0) {
            var neighbor = Cell.of(cell.r - 1, cell.c);
            if (isLand(grid, neighbor)) {
                connected.add(neighbor);
            }
        }

        if (cell.c > 0) {
            var neighbor = Cell.of(cell.r, cell.c - 1);
            if (isLand(grid, neighbor)) {
                connected.add(neighbor);
            }
        }

        if (cell.r < grid.size() - 1) {
            var neighbor = Cell.of(cell.r + 1, cell.c);
            if (isLand(grid, neighbor)) {
                connected.add(neighbor);
            }
        }

        if (cell.c < grid.get(0).size() - 1) {
            var neighbor = Cell.of(cell.r, cell.c + 1);
            if (isLand(grid, neighbor)) {
                connected.add(neighbor);
            }
        }

        return connected;
    }

    public static class Cell {
        public int r;
        public int c;

        public Cell(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public static Cell of(int r, int c) {
            return new Cell(r, c);
        }

        @Override
        public boolean equals(Object obj) {
            var that = (Cell) obj;
            return this.r == that.r && this.c == that.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.r, this.c);
        }
    }

}
