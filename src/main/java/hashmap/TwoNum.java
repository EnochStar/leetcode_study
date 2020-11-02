package hashmap;

import java.util.HashMap;
import java.util.Map;


/**
 * @author FL8000
 * 题目分析：给定一个整数数组 nums和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 链接：https://leetcode-cn.com/problems/two-sum
 * --------------------------------------------------------------------------------------------------
 * 分析：题目很简单，关键在于如何以满意的时间复杂度解决它。
 * 方法一：嵌套迭代 时间复杂度O（n^2）
 *
 * 方法二：运用HashMap，时间复杂度O（n）
 */
public class TwoNum {

    public int[] twoSumOne(int[] nums, int target) {
        int[] res = new int[2];
        for(int i = 0;i<nums.length-1;i++){
            for(int j = i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    res[0]=i;
                    res[1]=j;
                    return res;
                }
            }
        }
        return res;
    }
    public int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        Map<Integer,Integer> map = new HashMap();
        for(int i = 0;i < nums.length;i++){
            if(map.containsKey(nums[i])){
                index[0] = map.get(nums[i]);
                index[1] = i;
            }
            map.put(target - nums[i],i);
        }
        return index;
    }
}
