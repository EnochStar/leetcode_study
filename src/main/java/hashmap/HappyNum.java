package hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * @author FL8000
 * ��Ŀ��������дһ���㷨���ж�һ���� n �ǲ��ǿ�������
 *
 * ��������������Ϊ������һ����������ÿһ�ν������滻Ϊ��ÿ��λ���ϵ����ֵ�ƽ���ͣ�Ȼ���ظ��������ֱ���������Ϊ 1��
 * Ҳ������ ����ѭ�� ��ʼ�ձ䲻�� 1����� ���Ա�Ϊ1����ô��������ǿ�������
 *
 * ��� n �ǿ������ͷ��� True �����ǣ��򷵻� False ��
 * https://leetcode-cn.com/problems/happy-number/solution/
 * -----------------------------------------------------------------------------------------------------------
 * �������ؼ������жϺ�ʱ�˳���������hashset�洢ֵ��һ�����ֳ����ظ��ľ��˳�
 */
public class HappyNum {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet();
        set.add(n);
        int temp = getSum(n);
        while(!set.contains(temp)){
            set.add(temp);
            temp = getSum(temp);
            if(temp == 1){
                return true;
            }
        }
        return false;
    }
    public int getSum(int n){
        int sum = 0;
        while(n != 0){
            sum += Math.pow(n%10,2);
            n/=10;
        }
        return sum;
    }
}
