package hashmap;

import java.util.HashMap;
import java.util.Map;


/**
 * @author FL8000
 * ��Ŀ����������һ���������� nums��һ��Ŀ��ֵ target�������ڸ��������ҳ���ΪĿ��ֵ�����������������������ǵ������±ꡣ
 *
 * ����Լ���ÿ������ֻ���Ӧһ���𰸡����ǣ�������ͬһ��Ԫ�ز���ʹ�����顣
 * ���ӣ�https://leetcode-cn.com/problems/two-sum
 * --------------------------------------------------------------------------------------------------
 * ��������Ŀ�ܼ򵥣��ؼ���������������ʱ�临�ӶȽ������
 * ����һ��Ƕ�׵��� ʱ�临�Ӷ�O��n^2��
 *
 * ������������HashMap��ʱ�临�Ӷ�O��n��
 */
public class TwoNum {

    public int[] twoSumOne(int[] nums, int target) {
        int[] res = new int[2];
        for(int i = 0;i<nums.length-1;i++){
            for(int j = i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    res[0]=i;
                    res[1]=j;
                    return res;
                }
            }
        }
        return res;
    }
    public int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        Map<Integer,Integer> map = new HashMap();
        for(int i = 0;i < nums.length;i++){
            if(map.containsKey(nums[i])){
                index[0] = map.get(nums[i]);
                index[1] = i;
            }
            map.put(target - nums[i],i);
        }
        return index;
    }
}
