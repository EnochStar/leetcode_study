package com.bjx.dp;

import java.util.Arrays;
import java.util.List;

/**
 * @author EnochStar
 * @title: Triangle
 * @projectName leetcode_study
 * @description: 
 * ����һ�������Σ��ҳ��Զ����µ���С·���͡�ÿһ��ֻ���ƶ�����һ�������ڵĽ���ϡ�
 *
 * ���ڵĽ�� ������ָ���� �±� �� ��һ�����±� ��ͬ���ߵ��� ��һ�����±� + 1 ��������㡣
 *
 *  
 *
 * ���磬���������Σ�
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * �Զ����µ���С·����Ϊ 11������2 + 3 + 5 + 1 = 11����
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/triangle
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2020/12/20 14:26
 */
public class Triangle {
    // �Ե�����
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
    // �Զ����� �ޱ���¼

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

    // �Զ����� �б���¼
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
