package com.bjx.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author EnochStar
 * @title: ThreeSum
 * @projectName leetcode_study
 * @description: 
 * 给你一个包含 n 个整数的数组   nums，判断   nums   中是否存在三个元素 a，b，c ，使得   a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *    
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/1/26 20:05
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for(int i = 0;i < nums.length;i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            if(nums[i] > 0) return res;
            int L = i + 1;
            int R = nums.length - 1;
            while(L < R) {
                if(nums[i] + nums[L] + nums[R] == 0) {
                    res.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while(L < R && nums[L] == nums[L+1]) L++;
                    while (L < R && nums[R] == nums[R-1]) R--;
                    L++;
                    R--;
                }else if (nums[i] + nums[R] + nums[L] > 0) {
                    R--;
                }else{
                    L++;
                }
            }
        }
        return res;
    }
}
