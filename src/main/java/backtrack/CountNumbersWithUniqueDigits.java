package backtrack;

/**
 * @author EnochStar
 * @title: CountNumbersWithUniqueDigits
 * @projectName leetcode_study
 * @description:
 * ����һ���Ǹ����� n�������λ���ֶ���ͬ������ x �ĸ��������� 0 �� x < 10n��
 *
 * ʾ��:
 *
 * ����: 2
 * ���: 91
 * ����: ��ӦΪ��ȥ 11,22,33,44,55,66,77,88,99 �⣬�� [0,100) �����ڵ��������֡�
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/count-numbers-with-unique-digits
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2020/12/1014:17
 */
public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) {
            return 1;
        }
        if(n >= 10) return 0;
        boolean[] used = new boolean[10];
        return backtrack(used,0,n);
    }
    int backtrack(boolean[] used, int idx,int n){
        int count = 0;
        if(idx != n) {
            for(int i = 0;i < 10;i++) {
                if(used[i]) continue;
                if(i == 0 && n > 1 && idx == 1) continue;
                used[i] = true;
                count += backtrack(used,idx+1,n) + 1;
                used[i] = false;
            }
        }
        return count;
    }
}
