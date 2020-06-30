package com.apismensky;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n
 * chessboard such that no two queens attack each other.
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an
 * empty space respectively.
 *
 * Example:
 *
 * Input: 4 Output: [ [".Q..",  // NestedWeightListSumII 1 "...Q", "Q...", "..Q."],
 *
 * ["..Q.",  // NestedWeightListSumII 2 "Q...", "...Q", ".Q.."] ] Explanation:
 * There exist two distinct solutions to the 4-queens puzzle as shown
 * above.
 */
public class NQueen {

    private static class Location {
        int col;
        int row;

        private Location(int col, int row) {
            this.col = col;
            this.row = row;
        }

        @Override
        public boolean equals(Object o) {
            Location location = (Location)o;
            return col == location.col && row == location.row;
        }

        @Override
        public int hashCode() {
            return Objects.hash(col, row);
        }
    }

    private int size;
    private Stack<Location> stack;
    private List<List<Location>> solutions;

    public List<List<String>> placeQueens(int size) {
        this.size = size;
        this.stack = new Stack<>();
        this.solutions = new ArrayList<>();
        advance();
        return toLists();
    }

    private void advance() {
        for (int i = 0; i < size; i++) {
            Location location = new Location(i, stack.size()); // location candidate
            if (isValidLocation(location)) {
                stack.push(location);
                if (stack.size() == size)  // we placed all the queens
                    solutions.add(new ArrayList<>(stack));
                else
                    advance();
                if (!stack.isEmpty())
                    stack.pop();
            }
        }
    }

    private boolean isValidLocation(Location location) {
        for (Location l : stack) {
            if (location.col == l.col
                || location.row == l.row
                || location.row + location.col == l.row + l.col
                || location.row - location.col == l.row - l.col) {
                return false;
            }
        }
        return true;
    }

    public List<List<String>> toLists() {
        List<List<String>> results = new ArrayList<>();
        for (List solution : solutions) {
            List<String> result = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < size; j++) {
                    if (solution.contains(new Location(j, i))) sb.append("Q");
                    else sb.append(".");
                }
                result.add(sb.toString());
            }
            results.add(result);
        }
        return results;
    }

    @Override
    public String toString() {
        List<List<String>> results = toLists();
        StringBuilder sb = new StringBuilder();
        for (List<String> result : results) {
            for (String str : result)
                sb.append(str).append("\n");
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        NQueen nQueen = new NQueen();
        List<List<String>> lists = nQueen.placeQueens(5);
        System.out.println(lists);
        System.out.println(nQueen);
    }
}
