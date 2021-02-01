package com.bjx.hashmap;

import java.util.*;

/**
 * @author EnochStar
 * @title: GroupAnagrams
 * @projectName leetcode_study
 * @description:
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/2/1 14:49
 */
public class GroupAnagrams {
    // 方法1、暴力法 超时
    public List<List<String>> groupAnagrams(String[] strs) {
        boolean[] flag = new boolean[strs.length];
        List<List<String>> res = new ArrayList();
        for(int i = 0;i < strs.length;i++) {
            if(flag[i]) continue;
            flag[i] = true;
            List<String> list = new ArrayList();
            list.add(strs[i]);
            for(int j = i + 1;j < strs.length;j++) {
                if(flag[j]) continue;
                if(isAnagrams(strs[i],strs[j])) {
                    list.add(strs[j]);
                    flag[j] = true;
                }
            }
            res.add(list);
        }
        return res;
    }
    public boolean isAnagrams(String s,String t) {
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        return Arrays.equals(s1,t1);
    }
    // 方法2、
    public List<List<String>> groupAnagramsTwo(String[] strs) {
        if(strs == null || strs.length == 0) {
            return new ArrayList();
        }
        Map<String,List<String>> map = new HashMap();
        for(String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String keyStr = String.valueOf(c);
            if(map.get(keyStr) == null) {
                map.put(keyStr,new ArrayList());
            }
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
