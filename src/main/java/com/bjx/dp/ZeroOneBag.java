package com.bjx.dp;

/**
 * @author EnochStar
 * @title: ZeroOneBag
 * @projectName leetcode_study
 * @description:
 * 链接：https://ac.nowcoder.com/questionTerminal/7e157ce9a8c249daa3ddafad322dbf1e
 * 来源：牛客网
 *
 * 有为N件物品，它们的重量w分别是w1,w2,...,wn，它们的价值v分别是v1,v2,...,vn，每件物品数量有且仅有一个，现在给你个承重为M的背包，求背包里装入的物品具有的价值最大总和？
 *
 * 输入描述:
 * 物品数量N=5件
 * 重量w分别是2 2 6 5 4
 * 价值v分别是6 3 5 4 6
 * 背包承重为M=10
 *
 *
 * 输出描述:
 * 背包内物品最大总和为15
 * 示例1
 * 输入
 * 5
 * 10
 * 2 2 6 5 4
 * 6 3 5 4 6
 * 输出
 * 15
 * @date 2021/1/1 10:51
 */
public class ZeroOneBag {
    public int dp(int num,int weight,int[] w,int[] v) {
        int[][] dp = new int[num + 1][weight + 1];
        // 当背包可用容量为0时，其最大价值为0
        for(int i = 0;i <= num;i++) {
            dp[i][0] = 0;
        }
        // 当没有物品时，背包的最大价值为0
        for(int i = 0;i <= num;i++) {
            dp[0][i] = 0;
        }
        // 对于前i个物品，当前背包容量为w时的最大价值
        for(int i = 1;i <= num;i++) {
            for(int j = 1;j <= weight;j++) {
                // 当所用物品的容量大于当前容量时，不选择
                if(w[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                // 否则根据最值判断
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j - w[i - 1]] + v[i - 1],
                            dp[i - 1][j]);
                }
            }
        }
        return dp[num][weight];
    }
}
