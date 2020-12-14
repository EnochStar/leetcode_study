package com.bjx.backtrack;

import java.util.*;

/**
 * @author FL8000
 * ����һ�����ܰ����ظ�Ԫ�ص��������� nums�����ظ��������п��ܵ��Ӽ����ݼ�����
 *
 * ˵�����⼯���ܰ����ظ����Ӽ���
 *
 * ʾ��:
 *
 * ����: [1,2,2]
 * ���:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/subsets-ii
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class SubsetsII {
    // ������set�ǲ��еģ�set��ӵ��������list ��������list�ж���Ȼ��ͬ ��������һ����
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0, new LinkedList());
        return res;
    }
    void backtrack(int[] nums, int start, LinkedList<Integer> arr) {
        res.add(new ArrayList(arr));
        for(int i = start;i < nums.length; i++) {
            if(i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            arr.add(nums[i]);
            backtrack(nums,i + 1,arr);
            arr.removeLast();
        }
    }
}
