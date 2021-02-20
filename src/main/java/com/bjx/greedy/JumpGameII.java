package com.bjx.greedy;

/**
 * @author EnochStar
 * @title: JumpGameII
 * @projectName leetcode_study
 * @description: 
 * ����һ���Ǹ��������飬�����λ������ĵ�һ��λ�á�
 *
 * �����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�
 *
 * ���Ŀ����ʹ�����ٵ���Ծ����������������һ��λ�á�
 *
 * ʾ��:
 *
 * ����: [2,3,1,1,4]
 * ���: 2
 * ����: �������һ��λ�õ���С��Ծ���� 2��
 *      ���±�Ϊ 0 �����±�Ϊ 1 ��λ�ã��� 1 ����Ȼ���� 3 ��������������һ��λ�á�
 * ˵��:
 *
 * ���������ǿ��Ե�����������һ��λ�á�
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/jump-game-ii
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2021/2/20 12:12
 */
public class JumpGameII {
    public int jump(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        int reach = 0;
        int nextReach = nums[0];
        int step = 0;
        for(int i = 0;i < nums.length;i++) {
            nextReach = Math.max(nextReach,nums[i] + i);
            if(nextReach >= nums.length - 1) {
                return step+1;
            }
            if(i == reach) {
                reach = nextReach;
                step += 1;
            }
        }
        return step;
    }
}
