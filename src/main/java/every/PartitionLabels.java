package every;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author FL8000
 * ��Ŀ������
 * �ַ��� S ��Сд��ĸ��ɡ�����Ҫ������ַ�������Ϊ�����ܶ��Ƭ�Σ�ͬһ����ĸֻ����������е�һ��Ƭ�Ρ�
 * ����һ����ʾÿ���ַ���Ƭ�εĳ��ȵ��б�
 * ----------------------------------------------------------------------------------------
 * ������
 * �����ַ�������ȡ�����ַ������ֵ�λ�á��ٴα������ж϶�ȡ�Ӵ����Ƿ�ﵽ�����ֵ��Ǹ��ַ���Ȼ��ضϡ�
 *
 * https://leetcode-cn.com/problems/partition-labels/comments/
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        int[] a = new int[26];
        int start = 0;
        int end = 0;
        List<Integer> res = new ArrayList();
        for(int i = 0;i < S.length();i++){
            a[S.charAt(i) - 'a'] = i;
        }
        for(int i = 0;i < S.length();i++){
            end = Math.max(a[S.charAt(i) - 'a'], end);
            if(end == i){
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }
}
