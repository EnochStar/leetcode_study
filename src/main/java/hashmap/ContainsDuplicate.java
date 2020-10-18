package hashmap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author FL8000
 * ��Ŀ������
 * ����һ���������飬�ж��Ƿ�����ظ�Ԫ�ء�
 * �������һֵ�������г����������Σ��������� true �����������ÿ��Ԫ�ض�����ͬ���򷵻� false ��
 *
 * -----------------------------------------------------
 *
 * ������������hashset��������ʵ�֡�����ͨ������ķ������������ͬ����ôһ���ڽ���
 */
public class ContainsDuplicate {
    // ʱ�临�Ӷ�O��n��
    // public boolean containsDuplicate(int[] nums) {
    //     Set<Integer> set=new HashSet<Integer>();
    //     for (int i:nums){
    //         if (set.contains(i)){
    //             return true;
    //         }
    //         set.add(i);
    //     }
    //     return false;
    // }
    //ʱ�临�Ӷ�O��nlogn��
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }
}
