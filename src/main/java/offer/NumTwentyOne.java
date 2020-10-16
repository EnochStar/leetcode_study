/**
 * 题目描述：
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * 
 * 分析：
 * 这题思路上是比较简单的题，重点在于如何分别处理奇数和偶数。可以参考快排思想，采用双指针的形式进行处理。
 */
public class NumTwentyOne {
    public int[] exchange(int[] nums) {
        if(nums.length==0){
            return new int[0];
        }
        int fast=0;
        int las=nums.length-1;
        while(fast<las){
            while(fast<las&&nums[fast]%2==1){
                fast++;
            }
            while(las>0&&nums[las]%2==0){
                las--;
            }
            if(fast<las){
                int temp=nums[fast];
                nums[fast]=nums[las];
                nums[las]=temp;
            }
        }
        return nums;
    }
}
