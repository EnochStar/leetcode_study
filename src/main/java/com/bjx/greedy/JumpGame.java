package com.bjx.greedy;

/**
 * @author EnochStar
 * @title: JumpGame
 * @projectName leetcode_study
 * @description: 
 * ����һ���Ǹ��������� nums �������λ������� ��һ���±� ��
 *
 * �����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�
 *
 * �ж����Ƿ��ܹ��������һ���±ꡣ
 *
 *  
 *
 * ʾ�� 1��
 *
 * ���룺nums = [2,3,1,1,4]
 * �����true
 * ���ͣ��������� 1 �������±� 0 �����±� 1, Ȼ���ٴ��±� 1 �� 3 ���������һ���±ꡣ
 * ʾ�� 2��
 *
 * ���룺nums = [3,2,1,0,4]
 * �����false
 * ���ͣ������������ܻᵽ���±�Ϊ 3 ��λ�á������±�������Ծ������ 0 �� ������Զ�����ܵ������һ���±ꡣ
 *  
 *
 * ��ʾ��
 *
 * 1 <= nums.length <= 3 * 104
 * 0 <= nums[i] <= 105
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/jump-game
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2021/2/20 11:49
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        if(nums.length < 2){
            return true;
        }
        int i = nums.length - 1;
        for(int j = nums.length - 2;j >= 0;j--) {
            if(j + nums[j] >= i) {
                i = j;
            }
        }
        return i == 0;
    }
}
