package com.bjx.dp;

/**
 * @author EnochStar
 * @title: EditDistance
 * @projectName leetcode_study
 * @description: 
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *  
 *
 * 示例 1：
 *
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 *
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/12/25 11:20
 */
public class EditDistance {
    // 带备忘录的DP
    int[][] memo;
    public int minDistanceDPMemory(String word1, String word2) {
        memo = new int[word1.length()][word2.length()];
        return dp(word1, word2, word1.length() - 1, word2.length() - 1);
    }
    public int dp(String word1, String word2, int index1, int index2) {
        if(index1 == -1) {
            return index2 + 1;
        }
        if(index2 == -1) {
            return index1 + 1;
        }
        if(memo[index1][index2] != 0) {
            return memo[index1][index2];
        }
        if(word1.charAt(index1) == word2.charAt(index2)) {
            memo[index1][index2] = dp(word1, word2, index1 - 1,index2 - 1);
            return memo[index1][index2];
        }
        memo[index1][index2] = Math.min(dp(word1,word2,index1 - 1,index2) + 1,
                Math.min(dp(word1,word2,index1 - 1,index2 - 1),dp(word1,word2,index1,index2 - 1)) + 1);
        return memo[index1][index2];
    }

    // 自底向上 DP Table
    public int minDistanceDPTable(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for(int i = 1;i <= len1;i++) {
            dp[i][0] = i;
        }
        for(int j = 1;j <= len2;j++) {
            dp[0][j] = j;
        }
        for(int i = 1;i <= len1;i++) {
            for(int j = 1;j <= len2;j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                dp[i][j] = Math.min(dp[i - 1][j],Math.min(dp[i - 1][j - 1],dp[i][j - 1])) + 1;
            }
        }
        return dp[len1][len2];
    }
}
