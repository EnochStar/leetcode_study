package com.bjx.every;

/**
 * @author FL8000
 * 题目分析：给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地，0 表示水域。
 *
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿
 * （或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。
 * 网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 *
 * 链接：https://leetcode-cn.com/problems/island-perimeter
 * ---------------------------------------------------------------
 * 分析：求周长，及判断周边水域和边界情况，对于边界情况采用先污染后治理的方法，即先递归调用，再在dfs开头做判断
 *
 * 基本模板
 * // 处理方格位于网格边缘的情况
 * void dfs(int[][] grid, int r, int c) {
 *     // 若坐标不合法，直接返回
 *     if (!(0 <= r && r < grid.length && 0 <= c && c < grid[0].length)) {
 *         return;
 *     }
 *     // 若该方格不是岛屿，直接返回
 *     if (grid[r][c] != 1) {
 *         return;
 *     }
 *     dfs(grid, r - 1, c);
 *     dfs(grid, r + 1, c);
 *     dfs(grid, r, c - 1);
 *     dfs(grid, r, c + 1);
 * }
 *
 * 上例会出现死循环情况，故需要对走过的路径做标记，可以将其数组值改变，而不用创建一个逻辑数组做判断
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                if(grid[i][j] == 1){
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }
    public int dfs(int[][] grid, int x, int y){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length){
            return 1;
        }
        if(grid[x][y] == 0){
            return 1;
        }
        if(grid[x][y] != 1){
            return 0;
        }
        grid[x][y] = 2;
        return dfs(grid,x + 1,y) + dfs(grid,x - 1,y) + dfs(grid,x,y + 1) + dfs(grid,x,y-1);
    }
}
