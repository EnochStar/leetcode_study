package com.bjx.deque;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author EnochStar
 * @title: SlidingWindow
 * @projectName leetcode_study
 * @description: 
 * 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 *
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * 示例 3：
 *
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 * 示例 4：
 *
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 * 示例 5：
 *
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 * 
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -104<= nums[i] <= 104
 * 1 <= k <= nums.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
