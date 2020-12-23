package com.bjx.dp;

/**
 * @author EnochStar
 * @title: TheMasseuseLCCI
 * @projectName leetcode_study
 * @description:
 * һ�������İ�Ħʦ���յ�ԴԴ���ϵ�ԤԼ����ÿ��ԤԼ������ѡ��ӻ򲻽ӡ���ÿ��ԤԼ����֮��Ҫ����Ϣʱ�䣬��������ܽ������ڵ�ԤԼ������һ��ԤԼ�������У��水Ħʦ�ҵ����ŵ�ԤԼ���ϣ���ԤԼʱ������������ܵķ�������
 *
 * ע�⣺�������ԭ�������Ķ�
 *
 *    
 *
 * ʾ�� 1��
 *
 * ���룺 [1,2,3,1]
 * ����� 4
 * ���ͣ� ѡ�� 1 ��ԤԼ�� 3 ��ԤԼ����ʱ�� = 1 + 3 = 4��
 * ʾ�� 2��
 *
 * ���룺 [2,7,9,3,1]
 * ����� 12
 * ���ͣ� ѡ�� 1 ��ԤԼ�� 3 ��ԤԼ�� 5 ��ԤԼ����ʱ�� = 2 + 9 + 1 = 12��
 * ʾ�� 3��
 *
 * ���룺 [2,1,4,5,3,1,1,3]
 * ����� 12
 * ���ͣ� ѡ�� 1 ��ԤԼ�� 3 ��ԤԼ�� 5 ��ԤԼ�� 8 ��ԤԼ����ʱ�� = 2 + 4 + 3 + 3 = 12��
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/the-masseuse-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2020/12/23 10:43
 */
public class TheMasseuseLCCI {
    // public int massage(int[] nums) {
    //     int len = nums.length;
    //     if(len == 0) return 0;
    //     if(len == 1) return nums[0];
    //     if(len == 2) return Math.max(nums[0],nums[1]);
    //     if(len == 3) return Math.max(nums[1],nums[0] + nums[2]);
    //     int[] dp = new int[len];
    //     dp[0] = nums[0];
    //     dp[1] = nums[1];
    //     dp[2] = nums[2] + nums[0];
    //     for(int i = 3;i < len;i++) {
    //         dp[i] = Math.max(dp[i - 2],dp[i - 3]) + nums[i];
    //     }
    //     return Math.max(dp[len - 1],dp[len - 2]);
    // }

    // �Ż�
    // public int massage(int[] nums) {
    //     int len = nums.length;
    //     if(len == 0) return 0;
    //     if(len == 1) return nums[0];
    //     int[] dp = new int[nums.length];
    //     dp[0] = nums[0];
    //     dp[1] = Math.max(dp[0],nums[1]);
    //     for(int i = 2; i < len;i++) {
    //         dp[i] = Math.max(dp[i - 1],dp[i - 2] + nums[i]);
    //     }
    //     return dp[len - 1];
    // }

    // ���Ż�

    public int massage(int[] nums) {
        int len = nums.length;
        int a = 0;
        int b = 0;
        for(int i = 0;i < len;i++) {
            int c = Math.max(a + nums[i],b);
            a = b;
            b = c;
        }
        return b;
    }
}
