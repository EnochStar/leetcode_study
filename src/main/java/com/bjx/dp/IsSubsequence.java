package com.bjx.dp;

/**
 * @author EnochStar
 * @title: IsSubsequence
 * @projectName leetcode_study
 * @description: 
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 进阶：
 *
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/12/22 14:26
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        boolean[][] table = new boolean[s.length() + 1][t.length() + 1];
        for(int i = 0;i < table[0].length;i++) {
            table[0][i] = true;
        }
        for(int row = 1;row < table.length;row++) {
            char c1 = s.charAt(row - 1);
            for(int col = 1;col < table[0].length;col++) {
                char c2 = t.charAt(col - 1);
                if(c1 == c2) table[row][col] = table[row - 1][col - 1];
                else table[row][col] = table[row][col - 1];
            }
        }
        return table[table.length - 1][table[0].length - 1];
    }
}
