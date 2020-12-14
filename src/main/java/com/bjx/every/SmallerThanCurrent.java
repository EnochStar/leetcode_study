package com.bjx.every;

/**
 * @author FL8000
 * ��Ŀ����������һ������ nums����������ÿ��Ԫ�� nums[i]������ͳ�������б���С���������ֵ���Ŀ��
 *
 * ������֮������ÿ�� nums[i] �����������Ч�� j ������������ j ���� j != i �� nums[j] < nums[i] ��
 *
 * ��������ʽ���ش𰸡�
 * ---------------------------------------------------------------------------
 *
 * ������
 * ˼·һ��ѭ��Ƕ�� O��n^2��
 * ˼·������������ �ռ任ʱ�� O��n��
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
