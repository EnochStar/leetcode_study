package hashmap;

import java.util.*;

/**
 * @author FL8000
 * ��Ŀ�����������������飬��дһ���������������ǵĽ�����
 * ----------------------------------------------
 * �������ù�ϣ�����ѵ�����setתΪint���͵����飬��Ҫ�õ�lambda���ʽ
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet();
        for(int i : nums1){
            set.add(i);
        }
        Set<Integer> res = new HashSet<>();
        for(int i : nums2){
            if(set.contains(i)){
                res.add(i);
            }
        }
        int[] ans = res.stream().mapToInt(Number::intValue).toArray();
        return ans;
    }
}
