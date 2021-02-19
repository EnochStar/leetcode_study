package com.bjx.greedy;

import java.util.Arrays;

/**
 * @author EnochStar
 * @title: AssignCookie
 * @projectName leetcode_study
 * @description: 
 * 输出1。
 * 示例 2:
 *
 * 输入: g = [1,2], s = [1,2,3]
 * 输出: 2
 * 解释: 
 * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 * 所以你应该输出2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/assign-cookies
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/2/19 11:00
 */
public class AssignCookie {
    public int findContentChildren(int[] g, int[] s) {
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0,j = 0;
        while(i < g.length && j < s.length) {
            if(s[j] >= g[i]) {
                count++;
                i++;
                j++;
            }else{
                j++;
            }
        }
        return count;
    }
}
