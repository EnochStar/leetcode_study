package com.bjx.backtrack;

/**
 * @author EnochStar
 * @title: PermutationSequence
 * @projectName leetcode_study
 * @description:
 * �������� [1,2,3,...,n]��������Ԫ�ع��� n! �����С�
 *
 * ����С˳���г����������������һһ��ǣ��� n = 3 ʱ, �����������£�
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * ���� n �� k�����ص� k �����С�
 *
 *  
 *
 * ʾ�� 1��
 *
 * ���룺n = 3, k = 3
 * �����"213"
 * ʾ�� 2��
 *
 * ���룺n = 4, k = 9
 * �����"2314"
 * ʾ�� 3��
 *
 * ���룺n = 3, k = 1
 * �����"123"
 *  
 *
 * ��ʾ��
 *
 * 1 <= n <= 9
 * 1 <= k <= n!
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/permutation-sequence
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 *
 * ��᣺ ���ݵĽ��������ģ����Ը������Ĳ�ν��м�֦��ע�� �����γɵ����������һ��������������
 * @date 2020/12/814:05
 */
public class PermutationSequence {
    int n;
    int k;
    int[] fac;
    boolean[] used;
    String res;
    public String getPermutation(int n, int k) {
        this.k = k;
        this.n = n;
        factorial(n);
        used = new boolean[n + 1];
        backtrack(0, n, new StringBuilder());
        return res;
    }
    void backtrack(int index, int n, StringBuilder sb) {
        if(index == n) {
            res = sb.toString();
            return;
        }
        // ʣ��Ĳ�����Ӧ�Ľ�
        int cnt = fac[n - 1 - index];
        for(int i = 1;i <= n;i++) {
            if(used[i]) continue;
            if(k > cnt) {
                k -= cnt;
                continue;
            }
            sb.append(i);
            used[i] = true;
            backtrack(index + 1,n,sb);
            return;
        }
    }
    public void factorial(int n) {
        fac = new int[n + 1];
        fac[0] = 1;
        for(int i = 1;i <= n;i++) {
            fac[i] = fac[i - 1] * i;
        }
    }
}
