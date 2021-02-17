package com.bjx.bfs;

import java.util.HashSet;

/**
 * @author EnochStar
 * @title: MinMutation
 * @projectName leetcode_study
 * @description: TODO
 * @date 2021/2/17 15:17
 */
public class MinMutation {
    int minChange = Integer.MAX_VALUE;
    public int minMutation(String start, String end, String[] bank) {
        dfs(new HashSet<String>(),0,start,end,bank);
        return minChange == Integer.MAX_VALUE ? -1 : minChange;
    }
    public void dfs(HashSet<String> set,int level,String start,String end,String[] bank) {
        if(start.equals(end)) {
            minChange = Math.min(minChange,level);
            return;
        }
        for(String s : bank) {
            int count = 0;
            for(int i = 0;i < s.length();i++) {
                if(s.charAt(i) != start.charAt(i)) {
                    count++;
                }
                if(count > 1) {
                    break;
                }
            }
            if(count == 1 && !set.contains(s)) {
                set.add(s);
                dfs(set,level + 1,s,end,bank);
                set.remove(s);
            }
        }
    }
}
