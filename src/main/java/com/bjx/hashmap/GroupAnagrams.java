package com.bjx.hashmap;

import java.util.*;

/**
 * @author EnochStar
 * @title: GroupAnagrams
 * @projectName leetcode_study
 * @description:
 * ����һ���ַ������飬����ĸ��λ�������һ����ĸ��λ��ָ��ĸ��ͬ�������в�ͬ���ַ�����
 *
 * ʾ��:
 *
 * ����: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * ���:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * ˵����
 *
 * ���������ΪСд��ĸ��
 * �����Ǵ������˳��
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/group-anagrams
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2021/2/1 14:49
 */
public class GroupAnagrams {
    // ����1�������� ��ʱ
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
    // ����2��
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
