package com.apismensky;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * A sudoku solution must satisfy all of the following rules:
 *
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * Empty cells are indicated by the character '.'.
 */
public class SudokuSolver {

    private Map<Integer, Integer>[] rows;
    private Map<Integer, Integer>[] cols;
    private Map<Integer, Integer>[] boxes;
    private char[][] board;

    static class Cell {
        final int i;
        final int j;

        public Cell(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public void solveSudoku(char[][] board) {
        this.board = board;
        int length = board.length;
        rows = new HashMap[length];
        cols = new HashMap[length];
        boxes = new HashMap[length];
        for (int i = 0; i < length; i++) {
            rows[i] = new HashMap<>();
            cols[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                char num = board[i][j];
                if (num != '.')
                    saveHash(i, j, num);
            }
        }
        solve(new Cell(0, 0), null);
    }


    private void saveHash(int i, int j, char num) {
        int n = Character.getNumericValue(num);
        int box = getBoxIndex(i, j);
        rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
        cols[j].put(n, cols[j].getOrDefault(n, 0) + 1);
        boxes[box].put(n, boxes[box].getOrDefault(n, 0) + 1);
    }

    private void unsetHash(Cell cell) {
        if (cell == null) return;
        int n = Character.getNumericValue(board[cell.i][cell.j]);
        rows[cell.i].remove(n);
        cols[cell.j].remove(n);
        boxes[getBoxIndex(cell.i, cell.j)].remove(n);
    }

    /**
     * For row number 0-2, the box_index
     * can only be 0, 1, or 2, which can be determined by column number
     * divided by 3 : col / 3. For row number 3-5, the box_index is 3, 4, 5,
     * which can be determined by (1 * 3 + col / 3), and 1 = row / 3.
     * Same reason for row number 6-8, the box_index is
     * (2 * 3 + col / 3), and 2 = row / 3. As to why multiply by 3 is because
     * every 3 row from left to right contains 3 boxes.
     */
    private static int getBoxIndex(int i, int j) {
        return (i / 3 ) * 3 + j / 3;
    }

    private boolean solve(Cell cell, Cell prev) {
        Cell next = resolveNext(cell, board);
        if (board[cell.i][cell.j] != '.') {
            if (next == null)
                return true;
            return solve(next, prev);
        } else {
            for (int i = 1; i <= board.length; i++) {
                boolean validPlacement = isValidPlacement(cell, i);
                if (validPlacement) {
                    char digit = Character.forDigit(i, 10);
                    board[cell.i][cell.j] = digit;
                    saveHash(cell.i, cell.j, digit);
                    if (next == null || solve(next, cell))
                        return true;
                }
            }
        }
        unsetHash(prev);
        board[cell.i][cell.j] = '.'; // Backtrack
        return false;
    }

    private boolean isValidPlacement(Cell cell, int value) {
        return rows[cell.i].getOrDefault(value, 0) == 0 &&
               cols[cell.j].getOrDefault(value, 0) == 0 &&
               boxes[getBoxIndex(cell.i, cell.j)].getOrDefault(value, 0) == 0;
    }

    private Cell resolveNext(Cell cell, char[][] board) {
        if (cell.i == board.length - 1 && cell.j == board.length - 1)
            // finished the board
            return null;
        if (cell.j == board.length - 1)
            return new Cell(cell.i + 1, 0);
        else
            return new Cell(cell.i, cell.j + 1);
    }

    public static void main(String[] args) {

        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        printBoard(board);
        long start = System.currentTimeMillis();
        SudokuSolver sudokuSolver = new SudokuSolver();
        sudokuSolver.solveSudoku(board);
        System.out.println("Time, ms: " + (System.currentTimeMillis() - start));
        printBoard(board);
    }

    private static void printBoard(char[][] board) {
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}
