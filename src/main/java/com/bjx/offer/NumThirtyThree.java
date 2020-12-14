package com.bjx.offer;

/**
 * @author FL8000
 * ��Ŀ����������һ���������飬�жϸ������ǲ���ĳ�����������ĺ�����������������򷵻� true��
 * ���򷵻� false���������������������������ֶ�������ͬ��
 *
 * --------------------------------------------------------------------------
 *
 * ��������������γ����飬���һ��һ���Ǹ��ڵ㣬��ǰ�����ҵ���һ�����ڸ��ڵ��ֵ��Ϊ�߽磬������������
 */
public class NumThirtyThree {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }
    public boolean recur(int[] postorder, int start, int end){
        if (start >= end){
            return true;
        }
        int p = start;
        while(postorder[p] < postorder[end]){
            p++;
        }
        int m = p;
        while (postorder[p] > postorder[end]){
            p++;
        }
        return p == end && recur(postorder, start, m-1) && recur(postorder, m, end-1);
    }
}
