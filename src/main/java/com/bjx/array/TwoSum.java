package com.bjx.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author EnochStar
 * @title: TwoSum
 * @projectName leetcode_study
 * @description: 
 * 给定一个整数数组 nums  和一个整数目标值 target，请你在该数组中找出 和为目标值 的那  两个  整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 你可以按任意顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/1/26 19:41
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap();
        for(int i = 0;i < nums.length;i++) {
            if(map.containsKey(nums[i])) {
                res[0] = map.get(nums[i]);
                res[1] = i;
            }
            map.put(target - nums[i],i);
        }
        return res;
    }
}
