package com.bjx.deque;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author EnochStar
 * @title: SlidingWindow
 * @projectName leetcode_study
 * @description: 
 * ����һ���������� nums����һ����СΪk�Ļ������ڴ������������ƶ�����������Ҳࡣ��ֻ���Կ����ڻ��������ڵ� k�����֡���������ÿ��ֻ�����ƶ�һλ��
 *
 * ���ػ��������е����ֵ��
 *
 * 
 *
 * ʾ�� 1��
 *
 * ���룺nums = [1,3,-1,-3,5,3,6,7], k = 3
 * �����[3,3,5,5,6,7]
 * ���ͣ�
 * �������ڵ�λ��                ���ֵ
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * ʾ�� 2��
 *
 * ���룺nums = [1], k = 1
 * �����[1]
 * ʾ�� 3��
 *
 * ���룺nums = [1,-1], k = 1
 * �����[1,-1]
 * ʾ�� 4��
 *
 * ���룺nums = [9,11], k = 2
 * �����[11]
 * ʾ�� 5��
 *
 * ���룺nums = [4,-2], k = 2
 * �����[4]
 * 
 *
 * ��ʾ��
 *
 * 1 <= nums.length <= 105
 * -104<= nums[i] <= 104
 * 1 <= k <= nums.length
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/sliding-window-maximum
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2021/1/30 19:37
 */
public class SlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if(len == 0) {
            return nums;
        }
        int[] res = new int[len - k + 1];
        int index = 0;
        Deque<Integer> deque = new ArrayDeque();
        for(int i = 0;i < k;i++) {
            while(!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.removeLast();
            }
            deque.offerLast(nums[i]);
        }
        res[index++] = deque.peekFirst();
        for(int j = k;j < len;j++) {
            if(deque.peekFirst() == nums[j - k]) {
                deque.removeFirst();
            }
            while(!deque.isEmpty() && deque.peekLast() < nums[j]) {
                deque.removeLast();
            }
            deque.offerLast(nums[j]);
            res[index++] = deque.peekFirst();
        }
        return res;
    }
}
