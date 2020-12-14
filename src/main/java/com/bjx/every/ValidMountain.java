package com.bjx.every;

/**
 * @author FL8000
 * 题目分析：给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 *
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 *
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 *
 * 链接：https://leetcode-cn.com/problems/valid-mountain-array
 * -------------------------------------------------------------------------------
 * 分析：先上在下，即找到其最高点的值和坐标。需要注意山脉不能在数组首和数组尾。
 */
public class ValidMountain {
    // 方法一
    public boolean validMountainArray(int[] A) {
        if(A.length < 3){
            return false;
        }
        int max = 0;
        int index_max = 0;
        for(int i = 0;i < A.length;i++){
            if(A[i] > max){
                max = A[i];
                index_max = i;
            }
        }
        if(index_max == 0 || index_max == A.length-1){
            return false;
        }
        for(int i = 1;i < A.length;i++){
            if(i <= index_max){
                if(A[i]<=A[i-1]){
                    return false;
                }
            }else{
                if(A[i]>=A[i-1]){
                    return false;
                }
            }
        }
        return true;
    }

    // 方法二 需要注意left和right的边界问题 对应首或尾为山顶的情况 性能更佳

    public boolean validMountainArrayTwo(int[] A) {
        if(A.length < 3){
            return false;
        }
        int left = 0;
        int right = A.length - 1;

        while(left < A.length - 2 && A[left] < A[left + 1]){
            left++;
        }
        while(right > 1 && A[right] < A[right - 1]){
            right--;
        }
        return right == left;
    }
}
