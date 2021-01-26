package com.bjx.array;

/**
 * @author EnochStar
 * @title: MoveZero
 * @projectName leetcode_study
 * @description:
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/1/26 16:51
 */
public class MoveZero {
    // First Way
    // public void moveZeroes(int[] nums) {
    //     int len = nums.length;
    //     int insertIdx = 0;
    //     for(int i = 0;i < len;i++) {
    //         if(nums[i] != 0) {
    //             nums[insertIdx++] = nums[i];
    //         }
    //     }
    //     while(insertIdx < len) {
    //         nums[insertIdx++] = 0;
    //     }
    // }

    //--------------------------------------------------

    // Second Way
    public void moveZeroes(int[] nums) {
        int j = 0;
        int len = nums.length;
        for(int i = 0;i < len;i++) {
            if(nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }

}
