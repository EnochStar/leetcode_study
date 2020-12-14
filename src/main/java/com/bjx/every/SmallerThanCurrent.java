package com.bjx.every;

/**
 * @author FL8000
 * 题目分析：给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 *
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 *
 * 以数组形式返回答案。
 * ---------------------------------------------------------------------------
 *
 * 分析：
 * 思路一：循环嵌套 O（n^2）
 * 思路二：计数排序 空间换时间 O（n）
 */
public class SmallerThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ans = new int[101];
        for(int num : nums) {
            ans[num] += 1;
        }
        for(int i = 1;i < ans.length;i++) {
            ans[i] += ans[i-1];
        }
        for(int i = 0;i < nums.length;i++){
            nums[i] = nums[i] != 0 ? ans[nums[i]-1] : 0;
        }
        return nums;
    }
}
