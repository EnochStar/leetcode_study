package com.bjx.dp;

import java.util.Arrays;
import java.util.List;

/**
 * @author EnochStar
 * @title: Triangle
 * @projectName leetcode_study
 * @description: 
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 *  
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/12/20 14:26
 */
public class Triangle {
    // 自底向上
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> cur = triangle.get(i);
            for (int j = 0; j < cur.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + cur.get(j);
            }
        }
        return dp[0];
    }
    // 自顶向下 无备忘录

    public int minimumTotalFromTopWithoutMemo(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        return help(triangle, 0, 0);
    }

    public int help(List<List<Integer>> triangle, int row, int col) {
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }
        int left = help(triangle, row + 1, col);
        int right = help(triangle, row + 1, col + 1);
        return Math.min(left, right) + triangle.get(row).get(col);
    }

    // 自顶向下 有备忘录
    public int minimumTotalFromTopWithMemo(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        return helpMemo(triangle, 0, 0);
    }

    public int helpMemo(List<List<Integer>> triangle, int row, int col) {
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }
        int left = helpMemo(triangle, row + 1, col);
        int right = helpMemo(triangle, row + 1, col + 1);
        return Math.min(left, right) + triangle.get(row).get(col);
    }
}
