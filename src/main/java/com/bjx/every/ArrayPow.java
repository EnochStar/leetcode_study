package com.bjx.every;

/**
 * @author FL8000
 * 题目分析：
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 *
 * ----------------------------------------------------------------------------
 * 思路1、第一次遍历将负数取反，然后调用Arrays.sort()函数排序。时间复杂度O（nlogn）
 * 思路2、双指针思路，将头指针和尾指针标识的数的平方进行比较，新建一个数组进性存储。时间复杂度O（n）
 *
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 */
public class ArrayPow {
    
/**
 * @author FL8000
 * 题目分析：
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 *
 * ----------------------------------------------------------------------------
 * 思路1、第一次遍历将负数取反，然后调用Arrays.sort()函数排序。时间复杂度O（nlogn）
 * 思路2、双指针思路，将头指针和尾指针标识的数的平方进行比较，新建一个数组进性存储。时间复杂度O（n）
 *
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 */
    public int[] sortedSquares(int[] A) {
        int n=A.length;
        int[] ans=new int[n];
        int p=n-1;
        for(int i=0,j=n-1;i<=j;){
            if(A[i]*A[i]>A[j]*A[j]){
                ans[p]=A[i]*A[i];
                i++;
            }else{
                ans[p]=A[j]*A[j];
                j--;
            }
            p--;
        }
        return  ans;
    }
}
