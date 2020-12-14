package com.bjx.backtrack;

/**
 * @author EnochStar
 * @title: IsAdditiveNumber
 * @projectName leetcode_study
 * @description: 累加数是一个字符串，组成它的数字可以形成累加序列。
 *
 * 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
 *
 * 给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。
 *
 * 说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 *
 * 示例 1:
 *
 * 输入: "112358"
 * 输出: true 
 * 解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * 示例2:
 *
 * 输入: "199100199"
 * 输出: true 
 * 解释: 累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/additive-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 分析： 剪枝： 1、位数大于二，第一位为0的剪枝 2、读取到末尾，k的值小于2  3、其他数字不等于它前两个数相加的和
 * @date 2020/12/716:23
 */
public class IsAdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        return backtrack(num,num.length(),0,0,0,0);
    }
    boolean backtrack(String num, int len, int idx, long pre, long sum, int k) {
        if(idx == len) {
            return k > 2;
        }
        for(int i = idx; i < len; i++) {
            long cur = fetchNum(num,idx,i);
            if(cur < 0) continue;
            if(k >= 2 && cur != sum) continue;
            if(backtrack(num,len,i + 1,cur, pre + cur, k + 1)){
                return true;
            }
        }
        return false;
    }
    long fetchNum(String num, int left, int right) {
        if(left < right && num.charAt(left) == '0') return -1;
        long res = 0;
        while(left <= right) {
            res = res * 10 + num.charAt(left) - '0';
            left++;
        }
        return res;
    }
}
