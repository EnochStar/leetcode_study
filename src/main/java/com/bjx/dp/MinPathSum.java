package com.bjx.dp;

/**
 * @author EnochStar
 * @title: MinPathSum
 * @projectName leetcode_study
 * @description: 
 * ����һ�������Ǹ������� m x n ���� grid �����ҳ�һ�������Ͻǵ����½ǵ�·����ʹ��·���ϵ������ܺ�Ϊ��С��
 *
 * ˵����ÿ��ֻ�����»��������ƶ�һ����
 *
 *  
 *
 * ʾ�� 1��
 *
 *
 * ���룺grid = [[1,3,1],[1,5,1],[4,2,1]]
 * �����7
 * ���ͣ���Ϊ·�� 1��3��1��1��1 ���ܺ���С��
 * ʾ�� 2��
 *
 * ���룺grid = [[1,2,3],[4,5,6]]
 * �����12
 *  
 *
 * ��ʾ��
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/minimum-path-sum
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2020/12/21 9:29
 */
public class MinPathSum {
    // int[][] memo;
    // // �Զ�����
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
        // �Ե�����
        int m = grid.length;
        int n = grid[0].length;
        if (m == 0) return 0;
        // ����
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = grid[m - 1][n - 1];
        for(int i = m - 2;i >= 0;i--) {
            dp[i][n - 1] = dp[i + 1][n - 1] + grid[i][n - 1];
        }
        for (int j = n - 2;j >= 0;j--) {
            dp[m - 1][j] = dp[m - 1][j + 1] + grid[m - 1][j];
        }
        // ״̬ת�Ʒ���
        for (int i = m - 2;i >= 0;i--) {
            for (int j = n - 2;j >= 0;j--) {
                dp[i][j] = Math.min(dp[i + 1][j],dp[i][j + 1]) + grid[i][j];
            }
        }
        return dp[0][0];
    }
}
