package hashmap;

import java.util.*;

/**
 * @author FL8000
 * 题目分析：假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 *
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
 *
 * 链接：https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists
 * ----------------------------------------------------------------------------------------------------------
 * 分析：很繁琐 很繁琐 注意最少索引和的意思。不是返回一个，而是返回最小索引相同的那一堆（可能只有一个）
 */
public class MinIndexList {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> map = new HashMap();
        for(int i = 0;i < list1.length;i++){
            map.put(list1[i],i);
        }
        List<String> res = new ArrayList();
        int num = Integer.MAX_VALUE;
        for(int i = 0;i < list2.length;i++){
            if(map.containsKey(list2[i])){
                if(num == i + map.get(list2[i])){
                    res.add(list2[i]);
                }else if(num > i + map.get(list2[i])){
                    res.clear();
                    num = i + map.get(list2[i]);
                    res.add(list2[i]);
                }
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
