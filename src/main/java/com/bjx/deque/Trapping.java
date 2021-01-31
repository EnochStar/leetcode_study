package com.bjx.deque;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author EnochStar
 * @title: Trapping
 * @projectName leetcode_study
 * @description: 
 * 给定n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 
 *
 * 示例 1：
 *
 *
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
 * 示例 2：
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
