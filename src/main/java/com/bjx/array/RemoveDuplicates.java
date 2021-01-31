package com.bjx.array;

/**
 * @author EnochStar
 * @title: RemoveDuplicates
 * @projectName leetcode_study
 * @description: 
 * ����һ���������飬����Ҫ�� ԭ�� ɾ���ظ����ֵ�Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Σ������Ƴ���������³��ȡ�
 *
 * ��Ҫʹ�ö��������ռ䣬������� ԭ�� �޸��������� ����ʹ�� O(1) ����ռ����������ɡ�
 *
 *  
 *
 * ʾ�� 1:
 *
 * �������� nums = [1,1,2], 
 *
 * ����Ӧ�÷����µĳ��� 2, ����ԭ���� nums ��ǰ����Ԫ�ر��޸�Ϊ 1, 2�� 
 *
 * �㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
 * ʾ�� 2:
 *
 * ���� nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * ����Ӧ�÷����µĳ��� 5, ����ԭ���� nums ��ǰ���Ԫ�ر��޸�Ϊ 0, 1, 2, 3, 4��
 *
 * �㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
 *  
 *
 * ˵��:
 *
 * Ϊʲô������ֵ��������������Ĵ���������?
 *
 * ��ע�⣬�����������ԡ����á���ʽ���ݵģ�����ζ���ں������޸�����������ڵ������ǿɼ��ġ�
 *
 * ����������ڲ���������:
 *
 * // nums ���ԡ����á���ʽ���ݵġ�Ҳ����˵������ʵ�����κο���
 * int len = removeDuplicates(nums);
 *
 * // �ں������޸�����������ڵ������ǿɼ��ġ�
 * // ������ĺ������صĳ���, �����ӡ�������иó��ȷ�Χ�ڵ�����Ԫ�ء�
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2021/1/28 19:39
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if(nums == null) {
            return 0;
        }
        int fis = 0;
        int las = 1;
        while(las < nums.length) {
            if(nums[fis] != nums[las]) {
                nums[++fis] = nums[las];
            }
            las++;
        }
        return fis + 1;
    }
}