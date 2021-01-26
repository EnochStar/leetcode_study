package com.bjx.array;

/**
 * @author EnochStar
 * @title: ContainerWater
 * @projectName leetcode_study
 * @description: 
 * ���� n ���Ǹ����� a1��a2��...��an��ÿ�������������е�һ����(i,ai) ���������ڻ� n ����ֱ�ߣ���ֱ�� i �������˵�ֱ�Ϊ (i, ai) �� (i, 0) ���ҳ����е������ߣ�ʹ�������� x �Ṳͬ���ɵ�����������������ˮ��
 *
 * ˵�����㲻����б������
 * ʾ�� 2��
 *
 * ���룺height = [1,1]
 * �����1
 * ʾ�� 3��
 *
 * ���룺height = [4,3,2,1,4]
 * �����16
 * ʾ�� 4��
 *
 * ���룺height = [1,2,1]
 * �����2
 *
 * 
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/container-with-most-water
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2021/1/26 18:59
 */
public class ContainerWater {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right) {
            int high = height[left] < height[right]?height[left++]:height[right--];
            max = Math.max((right-left+1)*high,max);
        }
        return max;
    }
}
