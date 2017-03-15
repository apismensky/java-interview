package com.octanner;

import java.util.*;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the area of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally, vertically or diagonally.
 * You may assume all four edges of the grid are all surrounded by water.
 * The result should be an ordered array of island surfaces.

 Example 1:

 11110
 11001
 00000
 11000

 Answer: [2,7]

 Example 2:

 11000
 11000
 00000
 00011

 Answer: [2,4]

 */
public class Islands {

    public static void main(String[] a) {

        System.out.println(findIslands(new int[][]{
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,0,0,0},
                {0,0,0,1,1},
        }));

        System.out.println(findIslands(new int[][]{
                {1,1,1,1,0},
                {1,1,0,0,1},
                {0,0,0,0,0},
                {1,1,0,0,0}
        }));

        System.out.println(findIslands(new int[][]{
                {0, 0, 0, 0, 0, 0},
                {1, 0, 0, 1, 1, 1},
                {1, 0, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 1},
                {0, 0, 0, 1, 0, 0}
        }));

    }

    /**
     * Class that represents a point in the surface matrix
     */
    static class Point {
        Point(int r, int c, int ROWS, int COLS) {
            this.r = r;
            this.c = c;
            this.ROWS = ROWS;
            this.COLS = COLS;
        }

        final int r;
        final int c;
        final int ROWS;
        final int COLS;
        Set<Point> pointsAround;

        /**
         * Get a set of points around given point horizontally, vertically or diagonally.
         *
         * @return Set of points
         */
        Set<Point> getPointsAround() {
            if (pointsAround == null) {
                pointsAround = new HashSet<Point>();
                for (int i = Math.max(0, r - 1); i <= Math.min(ROWS - 1, r + 1); i++) {
                    for (int j = Math.max(0, c - 1); j <= Math.min(COLS - 1, c + 1); j++) {
                        if (i == this.r && j == this.c) continue;
                        pointsAround.add(new Point(i, j, ROWS, COLS));
                    }
                }
            }
            return pointsAround;
        }

        @Override
        public String toString() {
            return "[" + r + "," + c + "]";
        }
    }

    /**
     * Calculate the area of the connected surfaces
     * @param array initial matrix of the surface
     * @return sorted list of island surfaces sizes
     */
    static List<Integer> findIslands(int[][] array) {
        List<Integer> result = new ArrayList<Integer>();
        int ROWS = array.length;
        int COLS = array[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (array[r][c] == 1) {
                    Point p = new Point(r, c, ROWS, COLS);
                    int around = lookAround(p, array, visited);
                    if (around > 0) {
                        System.out.println("Points around " + p + " = " + around);
                        result.add(around);
                    }
                }
            }
        }
        Collections.sort(result);
        return result;
    }

    /**
     * Recursively looking around given point to see if there are other points filled with water
     * @param p given point
     * @param arr initial matrix of the surface
     * @param visited All visited points are marked as true
     * @return number of points filled with water
     */
    static int lookAround(Point p, int[][] arr, boolean[][] visited) {
        if (visited[p.r][p.c] || arr[p.r][p.c] == 0) return 0;
        int res = 1;
        visited[p.r][p.c] = true;
        Set<Point> around = p.getPointsAround();
        for (Point point : around)
            res += lookAround(point, arr, visited);
        return res;
    }
}
