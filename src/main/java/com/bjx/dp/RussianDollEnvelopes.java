package com.bjx.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author EnochStar
 * @title: RussianDollEnvelopes
 * @projectName leetcode_study
 * @description: 
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式  (w, h)  出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 说明:
 * 不允许旋转信封。
 *
 * 示例:
 *
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3 
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/russian-doll-envelopes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/12/28 14:56
 */
public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        // 二维数组 升序与降序
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        int[] height = new int[n];
        for (int i = 0;i < n;i++) {
            height[i] = envelopes[i][1];
        }
        return lengthOfLIS(height);
    }
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 1) return 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int max = 0;
        for(int i = 1;i < nums.length;i++) {
            int min = Integer.MIN_VALUE;
            for (int j = 0;j < i;j++) {
                if (nums[i] > nums[j]) {
                    min = Math.max(min, dp[j]);
                }
            }
            dp[i] = min < dp[i]?dp[i]:min+1;
            max = dp[i] > max?dp[i]:max;
        }
        return max;
    }
}
