package com.bjx.deque;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author EnochStar
 * @title: LargestRectangleArea
 * @projectName leetcode_study
 * @description: 
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 
 *
 *
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为[2,1,5,6,2,3]。
 *
 * 
 *
 *
 *
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为10个单位。
 *
 * 
 *
 * 示例:
 *
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/1/30 16:08
 */
public class LargestRectangleArea {
    //暴力法（超时）
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
