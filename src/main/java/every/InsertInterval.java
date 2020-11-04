package every;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FL8000
 * ��Ŀ����������һ�����ص��� ������������ʼ�˵�����������б�
 *
 * ���б��в���һ���µ����䣬����Ҫȷ���б��е�������Ȼ�����Ҳ��ص�������б�Ҫ�Ļ������Ժϲ����䣩��
 * https://leetcode-cn.com/problems/insert-interval/
 * ---------------------------------------------------------------------------------------
 * �����������������ɣ���Ҫ�����߼�������������ĺϲ����ơ�
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> list = new ArrayList();
        for(int[] interval : intervals){
            // �����޽���
            if(interval[0] > right){
                if(!placed){
                    list.add(new int[]{left,right});
                    placed = true;
                }
                list.add(interval);
            }else if(interval[1] >= left){
                left = Math.min(interval[0],left);
                right = Math.max(interval[1],right);
            }else{
                list.add(interval);
            }
        }
        if(!placed){
            list.add(new int[]{left,right});
        }
        return list.toArray(new int[list.size()][2]);
    }
}
