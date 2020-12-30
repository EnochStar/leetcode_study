package com.bjx.dp;

/**
 * @author EnochStar
 * @title: LongestPalindromicSubsequence
 * @projectName leetcode_study
 * @description:
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 *
 *
 *
 * 示例 1:
 * 输入:
 *
 * "bbbab"
 * 输出:
 *
 * 4
 * 一个可能的最长回文子序列为 "bbbb"。
 *
 * 示例 2:
 * 输入:
 *
 * "cbbd"
 * 输出:
 *
 * 2
 * 一个可能的最长回文子序列为 "bb"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/12/30 11:41
 */
public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        if(n == 1) return 1;
        if(n == 2) return s.charAt(0) == s.charAt(1) ? 2:1;
        for(int i = 0;i < n;i++) {
            dp[i][i] = 1;
        }
        for(int i = n - 1;i >= 0;i--) {
            for(int j = i + 1;j < n;j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i + 1][j],dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
