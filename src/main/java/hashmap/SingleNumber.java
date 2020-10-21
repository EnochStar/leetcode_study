package hashmap;

import java.util.HashMap;

/**
 * @author FL8000
 * 题目描述：
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * -----------------------------------------------------------------------
 * 分析：
 * 1、哈希表
 * 2、异或
 *
 * https://leetcode-cn.com/problems/single-number/
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int temp = nums[0];
        for(int i = 1;i < nums.length;i++){
            temp ^= nums[i];
        }
        return temp;
    }
    public int singleNumberHash(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap();
        for(Integer i : nums){
            if(map.keySet().contains(i)){
                map.put(i,true);
                continue;
            }
            map.put(i,false);
        }
        for(Integer i : map.keySet()){
            if(!map.get(i)){
                return i;
            }
        }
        return -1;
    }
}
