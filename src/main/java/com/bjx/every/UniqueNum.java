package com.bjx.every;

import java.util.*;

/**
 * @author FL8000
 * 题目分析：给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 *
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 *
 * -------------------------------------------------------------
 *
 * 分析：用map存储每个数及对应出现次数
 * 用set分析是否出现重复的次数
 */
public class UniqueNum {
    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int elem : arr){
            map.put(elem,map.getOrDefault(elem,0)+1);
        }
        return map.size() == new HashSet<Integer>(map.values()).size();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-3,0,1,-3,1,1,1,-3,10,0};
        boolean flag = uniqueOccurrences(arr);
        System.out.println(flag);
    }
}
