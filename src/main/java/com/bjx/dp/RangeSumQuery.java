package com.bjx.dp;

/**
 * @author EnochStar
 * @title: RangeSumQuery
 * @projectName leetcode_study
 * @description: 
 * 给定一个整数数组   nums，求出数组从索引  i  到  j（i  ≤  j）范围内元素的总和，包含  i、j  两点。
 *
 * 实现 NumArray 类：
 *
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 从索引  i  到  j（i  ≤  j）范围内元素的总和，包含  i、j  两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
 *   
 *
 * 示例：
 *
 * 输入：
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * 输出：
 * [null, 1, -1, -3]
 *
 * 解释：
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1)) 
 * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 *
 *
 * 分析： 本题的关键在于，会多次使用sumRange（）这个方法，为了节省时间，需要将其结果在初始化阶段就存放在数组当中
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/12/22 14:13
 */
public class RangeSumQuery {
    int[] num;
    int[] sum;
    public RangeSumQuery(int[] nums) {
        num = nums;
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for(int i = 1; i < nums.length + 1;i++) {
            sum[i] = sum[i - 1] + num[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}
