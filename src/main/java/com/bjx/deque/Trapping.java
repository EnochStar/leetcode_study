package com.bjx.deque;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author EnochStar
 * @title: Trapping
 * @projectName leetcode_study
 * @description: 
 * ����n ���Ǹ�������ʾÿ�����Ϊ 1 �����ӵĸ߶�ͼ�����㰴�����е����ӣ�����֮���ܽӶ�����ˮ��
 *
 * 
 *
 * ʾ�� 1��
 *
 *
 *
 * ���룺height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * �����6
 * ���ͣ������������� [0,1,0,2,1,0,1,3,2,1,2,1] ��ʾ�ĸ߶�ͼ������������£����Խ� 6 ����λ����ˮ����ɫ���ֱ�ʾ��ˮ���� 
 * ʾ�� 2��
 *
 * ���룺height = [4,2,0,3,2,5]
 * �����9
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/trapping-rain-water
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2021/1/31 16:50
 */
public class Trapping {
    public int trap(int[] height) {
        if(height == null) {
            return 0;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int area = 0;
        for (int i = 0; i < height.length;i++) {
            while(!deque.isEmpty() && height[i] > height[deque.peekLast()]) {
                int curIdx = deque.removeLast();
                while(!deque.isEmpty() && height[deque.peekLast()] == height[curIdx]) {
                    deque.removeLast();
                }
                if(!deque.isEmpty()) {
                    int stackTop = deque.peekLast();
                    area = area + (Math.min(height[i],height[stackTop]) - height[curIdx]) * (i - stackTop - 1);
                }
            }
            deque.offerLast(i);
        }
        return area;
    }
}
