package com.bjx.dp;

/**
 * @author EnochStar
 * @title: MinPathSum
 * @projectName leetcode_study
 * @description: 
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 示例 2：
 *
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 *  
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/12/21 9:29
 */
public class MinPathSum {
    // int[][] memo;
    // // 自顶向下
    // public int minPathSum(int[][] grid) {
    //     memo = new int[grid.length][grid[0].length];
    //     return dp(grid, 0, 0);
    // }
    // public int dp(int[][] grid, int row, int col) {
    //     if(row >= grid.length || col >= grid[0].length) return Integer.MAX_VALUE;
    //     if(row == grid.length - 1 && col == grid[0].length - 1) {
    //         return grid[row][col];
    //     }
    //     if(memo[row][col] != 0) {
    //         return memo[row][col];
    //     }
    //     memo[row][col] = Math.min(dp(grid,row + 1,col),dp(grid,row,col + 1)) + grid[row][col];
    //     return memo[row][col];
    // }
    public int minPathSum(int[][] grid) {
        // 自底向上
        int m = grid.length;
        int n = grid[0].length;
        if (m == 0) return 0;
        // 定义
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = grid[m - 1][n - 1];
        for(int i = m - 2;i >= 0;i--) {
            dp[i][n - 1] = dp[i + 1][n - 1] + grid[i][n - 1];
        }
        for (int j = n - 2;j >= 0;j--) {
            dp[m - 1][j] = dp[m - 1][j + 1] + grid[m - 1][j];
        }
        // 状态转移方程
        for (int i = m - 2;i >= 0;i--) {
            for (int j = n - 2;j >= 0;j--) {
                dp[i][j] = Math.min(dp[i + 1][j],dp[i][j + 1]) + grid[i][j];
            }
        }
        return dp[0][0];
    }
}
