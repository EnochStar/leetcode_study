package every;

import java.util.*;

/**
 * @author FL8000
 * 设计一个支持在平均时间复杂度O(1)下，执行以下操作的数据结构。
 * <p>
 * 注意: 允许出现重复元素。
 * <p>
 * insert(val)：向集合中插入元素 val。
 * remove(val)：当 val 存在时，从集合中移除一个 val。
 * getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。
 * <p>
 * 链接：https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed
 * ----------------------------------------------------------------------------------------
 * 分析：增删取都要求O（1）的时间复杂度，故可以想到空间换时间HashMap，val作为键，下标作为值，映射对应的List。
 * 因为能同时添加两个相同的数，故可以用Set存储下标。
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
        // val 在list中的位置
        int i = (int)it.next();
        // list中的最后一个位置
        int lastNum = list.get(list.size()-1);
        // 替换
        list.set(i,lastNum);
        // 删除val的一个索引位置
        map.get(val).remove(i);
        // 删除lastNum在set中的索引
        map.get(lastNum).remove(list.size()-1);
        if (i < list.size()-1){
            map.get(lastNum).add(i);
        }
        if (map.get(val).size() == 0){
            map.remove(val);
        }
        // 执行删除操作
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
