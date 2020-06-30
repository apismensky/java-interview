package com.apismensky;

import java.util.Objects;
import java.util.Stack;

/**
 The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



 Given an integer n, return the number of distinct solutions to the n-queens puzzle.

 Example:

 Input: 4
 Output: 2
 Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
 [
 [".Q..",  // NestedWeightListSumII 1
 "...Q",
 "Q...",
 "..Q."],

 ["..Q.",  // NestedWeightListSumII 2
 "Q...",
 "...Q",
 ".Q.."]
 ]

 */
public class NQueenII {

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
    private int solutions;

    public int totalNQueens(int size) {
        this.size = size;
        this.stack = new Stack<>();
        this.solutions = 0;
        advance();
        return solutions;
    }

    private void advance() {
        for (int i = 0; i < size; i++) {
            Location location = new Location(i, stack.size()); // location candidate
            if (isValidLocation(location)) {
                stack.push(location);
                if (stack.size() == size)  // we placed all the queens
                    solutions++;
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

    public static void main(String[] args) {
        NQueenII nQueen = new NQueenII();
        int result = nQueen.totalNQueens(8);
        System.out.println(result);
    }
}
