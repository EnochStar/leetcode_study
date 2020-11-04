package every;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author FL8000
 * ��Ŀ����������һ������ļ��ϣ���ϲ������ص������䡣
 * https://leetcode-cn.com/problems/merge-intervals/submissions/
 * ------------------------------------------------------
 * ��������Ҫ�ȶ������������Ȼ�����������жϣ����б�ת����
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0){
            return new int[0][0];
        }
        Arrays.sort(intervals,(x,y)->x[0]-y[0]);
        List<int[]> list = new ArrayList<>();
        int[] temp = intervals[0];
        for (int i = 1;i< intervals.length;i++){
            if (temp[1]<intervals[i][0]){
                list.add(temp);
                temp=intervals[i];
            }else if (temp[1]<intervals[i][1]){
                temp[1] = intervals[i][1];
            }
        }
        list.add(temp);
        return list.toArray(new int[list.size()][2]);
    }
}
