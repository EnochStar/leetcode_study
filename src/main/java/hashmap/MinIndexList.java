package hashmap;

import java.util.*;

/**
 * @author FL8000
 * ��Ŀ����������Andy��Doris�������ʱѡ��һ�Ҳ������������Ƕ���һ����ʾ��ϲ���������б�ÿ���������������ַ�����ʾ��
 *
 * ����Ҫ�������������ٵ��������ҳ����ǹ�ͬϲ���Ĳ����� ����𰸲�ֹһ������������д𰸲��Ҳ�����˳�� ����Լ������Ǵ���һ���𰸡�
 *
 * ���ӣ�https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists
 * ----------------------------------------------------------------------------------------------------------
 * �������ܷ��� �ܷ��� ע�����������͵���˼�����Ƿ���һ�������Ƿ�����С������ͬ����һ�ѣ�����ֻ��һ����
 */
public class MinIndexList {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> map = new HashMap();
        for(int i = 0;i < list1.length;i++){
            map.put(list1[i],i);
        }
        List<String> res = new ArrayList();
        int num = Integer.MAX_VALUE;
        for(int i = 0;i < list2.length;i++){
            if(map.containsKey(list2[i])){
                if(num == i + map.get(list2[i])){
                    res.add(list2[i]);
                }else if(num > i + map.get(list2[i])){
                    res.clear();
                    num = i + map.get(list2[i]);
                    res.add(list2[i]);
                }
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
