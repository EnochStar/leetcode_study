package com.bjx.dp;

/**
 * @author EnochStar
 * @title: LongestPalindromicSubstring
 * @projectName leetcode_study
 * @description:
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/12/30 10:05
 */
public class LongestPalindromicSubstring {
    // 双指针法
    // public String longestPalindrome(String s) {
    //     String res = new String();
    //     for (int i = 0;i < s.length();i++) {
    //         String s1 = substring(s,i,i);
    //         String s2 = substring(s, i, i + 1);
    //         res = res.length() > s1.length()?res:s1;
    //         res = res.length() > s2.length()?res:s2;
    //     }
    //     return res;
    // }
    // public String substring(String s, int left, int right) {
    //     while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
    //         left--;
    //         right++;
    //     }
    //     return s.substring(left,right + 1);
    // }

    // 动态规划

    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0;l < n;l++) {
            for (int i = 0;i + l < n;i++) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                }
                else if (l == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                }else{
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i,j + 1);
                }
            }
        }
        return ans;
    }
}
