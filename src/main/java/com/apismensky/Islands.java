package com.apismensky;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * <p/>
 * Example 1:
 * <p/>
 * 11110
 * 11010
 * 11000
 * 00000
 * <p/>
 * Answer: 1
 * <p/>
 * Example 2:
 * <p/>
 * 11000
 * 11000
 * 00100
 * 00011
 * <p/>
 * Answer: 3
 */

public class Islands {

    /**
     * Calculate the area of the connected surfaces
     *
     * @param grid initial matrix of the surface
     * @return sorted list of island surfaces sizes
     */
    public static int findIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        int result = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int r = 0; r < grid.length; r++)
            for (int c = 0; c < grid[0].length; c++)
                if (!visited[r][c] && grid[r][c] == '1') {
                    result++;
                    markIsland(r, c, grid, visited);
                }
        return result;
    }

    /**
     * Recursively looking around given point to see if there are other points filled with water
     *
     * @param r       row of the given point
     * @param c       col of the given point
     * @param grid     initial matrix of the surface
     * @param visited All visited points are marked as true
     * @return number of points filled with water
     */
    static void markIsland(int r, int c, char[][] grid, boolean[][] visited) {
        if (visited[r][c] || grid[r][c] == '0') return;
        visited[r][c] = true;
        if (r != 0) markIsland(r - 1, c, grid, visited); // top
        if (c != 0) markIsland(r, c - 1, grid, visited); // left
        if (r < grid.length - 1) markIsland(r + 1, c, grid, visited); // left
        if (c < grid[0].length - 1) markIsland(r, c + 1, grid, visited); // right
    }
}
