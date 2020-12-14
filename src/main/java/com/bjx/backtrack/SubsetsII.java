package com.bjx.backtrack;

import java.util.*;

/**
 * @author FL8000
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubsetsII {
    // 单纯用set是不行的，set添加的是无序的list 多个无序的list判断虽然不同 但内容是一样的
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
