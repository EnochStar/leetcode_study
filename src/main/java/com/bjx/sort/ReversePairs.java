package com.bjx.sort;

/**
 * @author EnochStar
 * @title: ReversePairs
 * @projectName leetcode_study
 * @description: 
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 *
 * 你需要返回给定数组中的重要翻转对的数量。
 *
 * 示例 1:
 *
 * 输入: [1,3,2,3,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [2,4,3,5,1]
 * 输出: 3
 * 注意:
 *
 * 给定数组的长度不会超过50000。
 * 输入数组中的所有数字都在32位整数的表示范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/2 15:18
 */
public class ReversePairs {
    public int reversePairs(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        return mergeSort(nums,0,nums.length - 1);
    }
    public int mergeSort(int[] nums,int left,int right) {
        if(right <= left) return 0;
        int mid = (left + right) >> 1;
        int count = mergeSort(nums,left,mid) + mergeSort(nums,mid + 1,right);
        int i = left,t = left,c = 0;
        int[] cache = new int[right - left + 1];
        for(int j = mid + 1;j <= right;j++,c++) {
            while(i <= mid && nums[i] <= 2 * (long)nums[j]) i++;
            while(t <= mid && nums[t] < nums[j]) cache[c++] = nums[t++];
            count += mid - i + 1;
            cache[c] = nums[j];
        }
        while(t <= mid) cache[c++] = nums[t++];
        System.arraycopy(cache,0,nums,left,right - left + 1);
        return count;
    }
}
