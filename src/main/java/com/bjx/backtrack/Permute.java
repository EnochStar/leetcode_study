package com.bjx.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author FL8000
 * ����һ�� û���ظ� ���ֵ����У����������п��ܵ�ȫ���С�
 *
 * ʾ��:
 *
 * ����: [1,2,3]
 * ���:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/permutations
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Permute {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums,new LinkedList<>());
        return res;
    }
    // ·�� �����б�
    void backtrack(int[] nums, LinkedList<Integer> road) {
        // ��ֹ����
        if(road.size() == nums.length) {
            res.add(road);
        }
        // ����
        for(int i = 0; i < nums.length; i++){
            if(road.contains(nums[i])) {
                continue;
            }
            // ǰ�� ���
            road.add(nums[i]);
            // �������� ��ȡ�ڵ�ֵ
            backtrack(nums,road);
            // ���� ����
            road.removeLast();
        }
    }
}
