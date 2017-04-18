package com.apismensky;


import java.io.IOException;

/**
 * The universe of the Game of Life is an infinite two-dimensional orthogonal grid of square cells,
 * each of which is in one of two possible states, alive or dead, or "populated" or "unpopulated"
 * (the difference may seem minor, except when viewing it as an early model of human/urban behaviour
 * simulation or how one views a blank space on a grid). Every cell interacts with its eight neighbours,
 * which are the cells that are horizontally, vertically, or diagonally adjacent.
 * At each step in time, the following transitions occur:
 * - Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
 * - Any live cell with two or three live neighbours lives on to the next generation.
 * - Any live cell with more than three live neighbours dies, as if by overpopulation.
 * - Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
 * The initial pattern constitutes the seed of the system.
 * The first generation is created by applying the above rules simultaneously to every cell in the
 * seed—births and deaths occur simultaneously, and the discrete moment at which this happens
 * is sometimes called a tick (in other words, each generation is a pure function of the preceding one).
 * The rules continue to be applied repeatedly to create further generations.
 */
public class GameOfLifeInt {


    private static final int A = 1;
    private static final int D = 0;

    // https://en.wikipedia.org/wiki/Conway's_Game_of_Life#/media/File:Game_of_life_beacon.gif
    private static final int[][] BEACON = new int[][]{
            {A, A, D, D},
            {A, D, D, D},
            {D, D, D, A},
            {D, D, A, A}};

    // https://en.wikipedia.org/wiki/Conway's_Game_of_Life#/media/File:I-Column.gif
    private static final int[][] ICOLUMN = new int[][]{
            {D, D, D, D, D, D, D, D, D, D, D},
            {D, D, D, D, D, D, D, D, D, D, D},
            {D, D, D, D, D, D, D, D, D, D, D},
            {D, D, D, D, D, D, D, D, D, D, D},
            {D, D, D, D, D, A, D, D, D, D, D},
            {D, D, D, D, A, D, A, D, D, D, D},
            {D, D, D, A, D, D, D, A, D, D, D},
            {D, D, D, A, D, D, D, A, D, D, D},
            {D, D, D, A, D, D, D, A, D, D, D},
            {D, D, D, A, D, D, D, A, D, D, D},
            {D, D, D, A, D, D, D, A, D, D, D},
            {D, D, D, A, D, D, D, A, D, D, D},
            {D, D, D, D, A, D, A, D, D, D, D},
            {D, D, D, D, D, A, D, D, D, D, D},
            {D, D, D, D, D, D, D, D, D, D, D},
            {D, D, D, D, D, D, D, D, D, D, D},
            {D, D, D, D, D, D, D, D, D, D, D},
            {D, D, D, D, D, D, D, D, D, D, D}
    };

    private static void printGrid(int[][] state) throws IOException {
        for (int[] rows : state) {
            for (int column : rows)
                System.out.print(column == A ? '*' : ' ');
            System.out.println();
        }
    }


    private static int[][] initGrid() {
        int[][] grid = ICOLUMN;
        if (grid.length < 1 || grid[0].length < 1)
            throw new IllegalArgumentException("Initial grid should be at least 1 x 1 size");
        return grid;
    }

    private static int numOfNeighbors(int[][] board, int row, int col) {
        int count = 0;
        for (int r = (row - 1 < 0) ? 0 : row - 1; r <= (row == board.length - 1 ? board.length - 1 : row + 1); r++) {
            for (int c = col - 1 < 0 ? 0 : col - 1; c <= (col == board[0].length - 1 ? board[0].length - 1 : col + 1); c++) {
                if (c == col && r == row) continue;
                if (board[r][c] == A) count++;
            }
        }
        return count;
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) throws Exception {
        int[][] grid = initGrid();
        do {
            clearScreen();
            printGrid(grid);
            tick(grid);
            Thread.sleep(1000L);
        } while (true);
    }

    private static void tick(int[][] board) {
        int[][] tempGrid = new int[board.length][board[0].length];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                int n = numOfNeighbors(board, r, c);
                if (board[r][c] == A && (n == 2 || n == 3) || board[r][c] == D && n == 3)
                    tempGrid[r][c] = A;
                else
                    tempGrid[r][c] = D;
            }
        }
        System.arraycopy(tempGrid, 0, board, 0, board.length);
    }


}
