package com.bjx.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author FL8000
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Permute {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums,new LinkedList<>());
        return res;
    }
    // 路径 任务列表
    void backtrack(int[] nums, LinkedList<Integer> road) {
        // 终止条件
        if(road.size() == nums.length) {
            res.add(road);
        }
        // 遍历
        for(int i = 0; i < nums.length; i++){
            if(road.contains(nums[i])) {
                continue;
            }
            // 前序 添加
            road.add(nums[i]);
            // 类似于树 读取节点值
            backtrack(nums,road);
            // 后序 撤销
            road.removeLast();
        }
    }
}
