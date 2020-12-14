package com.bjx.every;

/**
 * @author FL8000
 * ��Ŀ����������һ���������� A�����������Ч��ɽ������ͷ��� true�����򷵻� false��
 *
 * �����ǻع�һ�£���� A ����������������ô����һ��ɽ�����飺
 *
 * A.length >= 3
 * �� 0 < i < A.length - 1 �����£����� i ʹ�ã�
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 *
 * ���ӣ�https://leetcode-cn.com/problems/valid-mountain-array
 * -------------------------------------------------------------------------------
 * �������������£����ҵ�����ߵ��ֵ�����ꡣ��Ҫע��ɽ�������������׺�����β��
 */
public class ValidMountain {
    // ����һ
    public boolean validMountainArray(int[] A) {
        if(A.length < 3){
            return false;
        }
        int max = 0;
        int index_max = 0;
        for(int i = 0;i < A.length;i++){
            if(A[i] > max){
                max = A[i];
                index_max = i;
            }
        }
        if(index_max == 0 || index_max == A.length-1){
            return false;
        }
        for(int i = 1;i < A.length;i++){
            if(i <= index_max){
                if(A[i]<=A[i-1]){
                    return false;
                }
            }else{
                if(A[i]>=A[i-1]){
                    return false;
                }
            }
        }
        return true;
    }

    // ������ ��Ҫע��left��right�ı߽����� ��Ӧ�׻�βΪɽ������� ���ܸ���

    public boolean validMountainArrayTwo(int[] A) {
        if(A.length < 3){
            return false;
        }
        int left = 0;
        int right = A.length - 1;

        while(left < A.length - 2 && A[left] < A[left + 1]){
            left++;
        }
        while(right > 1 && A[right] < A[right - 1]){
            right--;
        }
        return right == left;
    }
}
