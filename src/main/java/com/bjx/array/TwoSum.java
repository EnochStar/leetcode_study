package com.bjx.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author EnochStar
 * @title: TwoSum
 * @projectName leetcode_study
 * @description: 
 * ����һ���������� nums  ��һ������Ŀ��ֵ target�������ڸ��������ҳ� ��ΪĿ��ֵ ����  ����  ���������������ǵ������±ꡣ
 *
 * ����Լ���ÿ������ֻ���Ӧһ���𰸡����ǣ�������ͬһ��Ԫ�ز���ʹ�����顣
 *
 * ����԰�����˳�򷵻ش𰸡�
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/two-sum
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2021/1/26 19:41
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap();
        for(int i = 0;i < nums.length;i++) {
            if(map.containsKey(nums[i])) {
                res[0] = map.get(nums[i]);
                res[1] = i;
            }
            map.put(target - nums[i],i);
        }
        return res;
    }
}
