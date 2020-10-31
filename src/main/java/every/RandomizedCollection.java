package every;

import java.util.*;

/**
 * @author FL8000
 * ���һ��֧����ƽ��ʱ�临�Ӷ�O(1)�£�ִ�����²��������ݽṹ��
 * <p>
 * ע��: ��������ظ�Ԫ�ء�
 * <p>
 * insert(val)���򼯺��в���Ԫ�� val��
 * remove(val)���� val ����ʱ���Ӽ������Ƴ�һ�� val��
 * getRandom�������м����������ȡһ��Ԫ�ء�ÿ��Ԫ�ر����صĸ���Ӧ�������ڼ����е�������������ء�
 * <p>
 * ���ӣ�https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed
 * ----------------------------------------------------------------------------------------
 * ��������ɾȡ��Ҫ��O��1����ʱ�临�Ӷȣ��ʿ����뵽�ռ任ʱ��HashMap��val��Ϊ�����±���Ϊֵ��ӳ���Ӧ��List��
 * ��Ϊ��ͬʱ���������ͬ�������ʿ�����Set�洢�±ꡣ
 */
public class RandomizedCollection {
    Map<Integer, Set<Integer>> map;
    List<Integer> list;

    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /**
     * Inserts a value to the collection.
     * Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        list.add(val);
        Set<Integer> set = map.getOrDefault(val, new HashSet<>());
        set.add(list.size() - 1);
        map.put(val, set);
        return set.size() == 1;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)){
            return false;
        }
        Iterator it = map.get(val).iterator();
        // val ��list�е�λ��
        int i = (int)it.next();
        // list�е����һ��λ��
        int lastNum = list.get(list.size()-1);
        // �滻
        list.set(i,lastNum);
        // ɾ��val��һ������λ��
        map.get(val).remove(i);
        // ɾ��lastNum��set�е�����
        map.get(lastNum).remove(list.size()-1);
        if (i < list.size()-1){
            map.get(lastNum).add(i);
        }
        if (map.get(val).size() == 0){
            map.remove(val);
        }
        // ִ��ɾ������
        list.remove(list.size()-1);
        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return list.get((int)(list.size()*Math.random()));
    }
}
