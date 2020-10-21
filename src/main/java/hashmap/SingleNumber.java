package hashmap;

import java.util.HashMap;

/**
 * @author FL8000
 * ��Ŀ������
 * ����һ���ǿ��������飬����ĳ��Ԫ��ֻ����һ�����⣬����ÿ��Ԫ�ؾ��������Ρ��ҳ��Ǹ�ֻ������һ�ε�Ԫ�ء�
 * -----------------------------------------------------------------------
 * ������
 * 1����ϣ��
 * 2�����
 *
 * https://leetcode-cn.com/problems/single-number/
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int temp = nums[0];
        for(int i = 1;i < nums.length;i++){
            temp ^= nums[i];
        }
        return temp;
    }
    public int singleNumberHash(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap();
        for(Integer i : nums){
            if(map.keySet().contains(i)){
                map.put(i,true);
                continue;
            }
            map.put(i,false);
        }
        for(Integer i : map.keySet()){
            if(!map.get(i)){
                return i;
            }
        }
        return -1;
    }
}
