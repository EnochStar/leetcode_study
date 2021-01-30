package com.bjx.deque;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author EnochStar
 * @title: LargestRectangleArea
 * @projectName leetcode_study
 * @description: 
 * ���� n ���Ǹ�������������ʾ��״ͼ�и������ӵĸ߶ȡ�ÿ�����ӱ˴����ڣ��ҿ��Ϊ 1 ��
 *
 * ���ڸ���״ͼ�У��ܹ����ճ����ľ��ε���������
 *
 * 
 *
 *
 *
 * ��������״ͼ��ʾ��������ÿ�����ӵĿ��Ϊ 1�������ĸ߶�Ϊ[2,1,5,6,2,3]��
 *
 * 
 *
 *
 *
 * ͼ����Ӱ����Ϊ���ܹ��ճ�������������������Ϊ10����λ��
 *
 * 
 *
 * ʾ��:
 *
 * ����: [2,1,5,6,2,3]
 * ���: 10
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2021/1/30 16:08
 */
public class LargestRectangleArea {
    //����������ʱ��
    // public int largestRectangleArea(int[] heights) {
    //     int max = 0;
    //     for(int i = 0;i < heights.length;i++) {
    //         int left = i;
    //         int right = i;
    //         while(left >= 0) {
    //             if(heights[left] < heights[i]) {
    //                 break;
    //             }
    //             left--;
    //         }
    //         while(right < heights.length) {
    //             if(heights[right] < heights[i]) {
    //                 break;
    //             }
    //             right++;
    //         }
    //         max = Math.max(max,(right - left  1) * heights[i]);
    //     }
    //     return max;
    // }
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] tmp = new int[heights.length + 2];
        tmp[0] = 0;
        System.arraycopy(heights,0,tmp,1,heights.length);
        int area = 0;
        for (int i = 0; i < tmp.length;i++) {
            while (!deque.isEmpty() && tmp[i] < tmp[deque.peek()]) {
                int h = tmp[deque.pop()];
                area = Math.max(area,h * (i - deque.peek() - 1));
            }
            deque.push(i);
        }
        return area;
    }
}
