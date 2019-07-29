package com.apismensky;

import java.util.HashMap;
import java.util.Map;

/**
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * Move along the board.
 * Check for each cell value if it was seen already in the current row / column / box :
 * Return false if yes.
 * Keep this value for a further tracking if no.
 * Return true.
 */
public class ValidSudoku {
    public static boolean isValidSudoku(char[][] input) {
        if (input == null) {
            return false;
        }
        int length = input.length;
        if (length == 0) {
            return true;
        }

        if (input[0].length != length) {
            return false;
        }

        Map<Integer, Integer>[] rows = new HashMap[length];
        Map<Integer, Integer>[] cols = new HashMap[length];
        Map<Integer, Integer>[] boxes = new HashMap[length];
        for (int i = 0; i < length; i++) {
            rows[i] = new HashMap<>();
            cols[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                char num = input[i][j];
                if (num != '.') {
                    int n = (int)num;
                    int box_index = getBoxIndex(i, j);
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    cols[j].put(n, cols[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);
                    // check if this value has been already seen before
                    if (rows[i].get(n) > 1 || cols[j].get(n) > 1 || boxes[box_index].get(n) > 1)
                        return false;
                }
            }
        }

        return true;
    }

    /**
     * For row number 0-2, the box_index
     * can only be 0, 1, or 2, which can be determined by column number
     * divided by 3 : col / 3. For row number 3-5, the box_index is 3, 4, 5,
     * which can be determined by (1 * 3 + col / 3), and 1 = row / 3.
     * Same reason for row number 6-8, the box_index is
     * (2 * 3 + col / 3), and 2 = row / 3. As to why multiply by 3 is because
     * every 3 row from left to right contains 3 boxes.
     *
     * @param i
     * @param j
     * @return
     */
    private static int getBoxIndex(int i, int j) {
        return (i / 3 ) * 3 + j / 3;
    }

    public static void main(String[] args) {
        char[][] input = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(isValidSudoku(input));
    }
}
