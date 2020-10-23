package hashmap;

import java.util.*;

/**
 * @author FL8000
 * 题目分析：给定两个数组，编写一个函数来计算它们的交集。
 * ----------------------------------------------
 * 分析：用哈希表处理，难点在于set转为int类型的数组，需要用到lambda表达式
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet();
        for(int i : nums1){
            set.add(i);
        }
        Set<Integer> res = new HashSet<>();
        for(int i : nums2){
            if(set.contains(i)){
                res.add(i);
            }
        }
        int[] ans = res.stream().mapToInt(Number::intValue).toArray();
        return ans;
    }
}
