package hashmap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author FL8000
 * 题目描述：
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 * -----------------------------------------------------
 *
 * 分析：可以用hashset的特性来实现。或者通过排序的方法进行如果相同，那么一定邻近。
 */
public class ContainsDuplicate {
    // 时间复杂度O（n）
    // public boolean containsDuplicate(int[] nums) {
    //     Set<Integer> set=new HashSet<Integer>();
    //     for (int i:nums){
    //         if (set.contains(i)){
    //             return true;
    //         }
    //         set.add(i);
    //     }
    //     return false;
    // }
    //时间复杂度O（nlogn）
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }
}
