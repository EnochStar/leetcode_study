package com.bjx.dp;

/**
 * @author EnochStar
 * @title: RangeSumQuery
 * @projectName leetcode_study
 * @description: 
 * ����һ����������   nums��������������  i  ��  j��i  ��  j����Χ��Ԫ�ص��ܺͣ�����  i��j  ���㡣
 *
 * ʵ�� NumArray �ࣺ
 *
 * NumArray(int[] nums) ʹ������ nums ��ʼ������
 * int sumRange(int i, int j) �������� nums ������  i  ��  j��i  ��  j����Χ��Ԫ�ص��ܺͣ�����  i��j  ���㣨Ҳ���� sum(nums[i], nums[i + 1], ... , nums[j])��
 *   
 *
 * ʾ����
 *
 * ���룺
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * �����
 * [null, 1, -1, -3]
 *
 * ���ͣ�
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1)) 
 * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 *
 *
 * ������ ����Ĺؼ����ڣ�����ʹ��sumRange�������������Ϊ�˽�ʡʱ�䣬��Ҫ�������ڳ�ʼ���׶ξʹ�������鵱��
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/range-sum-query-immutable
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
