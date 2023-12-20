package io.bsy.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class FloodFill {

    public List<List<Integer>> doFill(int r, int c, int replacement, List<List<Integer>> reference) {

        var image = new ArrayList<List<Integer>>();
        reference.forEach(lst -> {
            var copy = new ArrayList<>(lst);
            image.add(copy);
        });

        var queue = new LinkedList<Cell>();
        var visited = new HashSet<Cell>();

        var starting = Cell.of(r, c);
        int baseColor = getColor(image, starting);
        queue.add(starting);
        visited.add(starting);
        setColor(starting, image, replacement);

        while (!queue.isEmpty()) {
            var floodedSoFar = queue.size();
            for (int i = 0; i < floodedSoFar; i++) {
                var current = queue.removeFirst();

                var connected = getConnected(current, image, baseColor);
                for (var cell : connected) {
                    if (visited.contains(cell)) {
                        continue;
                    }
                    setColor(cell, image, replacement);
                    queue.addLast(cell);
                    visited.add(cell);
                }
            }
        }

        return image;
    }

    private int getColor(List<List<Integer>> image, Cell cell) {
        return image.get(cell.r).get(cell.c);
    }

    private void setColor(Cell cell, List<List<Integer>> image, int replacement) {
        image.get(cell.r).set(cell.c, replacement);
    }

    private List<Cell> getConnected(Cell cell, List<List<Integer>> image, int baseColor) {
        var connected = new ArrayList<Cell>();

        if (cell.r > 0) {
            var neighbor = Cell.of(cell.r - 1, cell.c);
            if (getColor(image, neighbor) == baseColor) {
                connected.add(neighbor);
            }
        }

        if (cell.c > 0) {
            var neighbor = Cell.of(cell.r, cell.c - 1);
            if (getColor(image, neighbor) == baseColor) {
                connected.add(neighbor);
            }
        }

        if (cell.r < image.size() - 1) {
            var neighbor = Cell.of(cell.r + 1, cell.c);
            if (getColor(image, neighbor) == baseColor) {
                connected.add(neighbor);
            }
        }

        if (cell.c < image.get(0).size() - 1) {
            var neighbor = Cell.of(cell.r, cell.c + 1);
            if (getColor(image, neighbor) == baseColor) {
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
