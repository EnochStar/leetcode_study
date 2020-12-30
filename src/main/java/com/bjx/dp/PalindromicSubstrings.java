package com.bjx.dp;

/**
 * @author EnochStar
 * @title: PalindromicSubstrings
 * @projectName leetcode_study
 * @description: 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * <p>
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 * <p>
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindromic-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/12/30 10:48
 */
public class PalindromicSubstrings {
    // 双指针法
    // public int countSubstrings(String s) {
    //     int sum = 0;
    //     for (int i = 0; i < s.length(); i++) {
    //         int count1 = substring(s, i, i);
    //         int count2 = substring(s, i, i + 1);
    //         sum = sum + count1 + count2;
    //     }
    //     return sum;
    // }
    //
    // public int substring(String s, int left, int right) {
    //     int count = 0;
    //     while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
    //         left--;
    //         right++;
    //         count++;
    //     }
    //     return count;
    // }

    // 动态规划

    public int countSubstrings(String s) {
        int n = s.length();
        boolean [][] dp = new boolean[n][n];
        int count = 0;
        for(int l = 0;l < n;l++) {
            for(int i = 0;i + l < n;i++) {
                int j = i + l;
                if(l == 0) {
                    dp[i][j] = true;
                    count++;
                }else if(l == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    count++;
                }else {
                    dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                    if(dp[i][j]) count++;
                }
            }
        }
        return count;
    }

}
