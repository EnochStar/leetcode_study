package hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * @author FL8000
 * 题目分析：编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，
 * 也可能是 无限循环 但始终变不到 1。如果 可以变为1，那么这个数就是快乐数。
 *
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 * https://leetcode-cn.com/problems/happy-number/solution/
 * -----------------------------------------------------------------------------------------------------------
 * 分析：关键在于判断何时退出，可以用hashset存储值，一旦发现出现重复的就退出
 */
public class HappyNum {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet();
        set.add(n);
        int temp = getSum(n);
        while(!set.contains(temp)){
            set.add(temp);
            temp = getSum(temp);
            if(temp == 1){
                return true;
            }
        }
        return false;
    }
    public int getSum(int n){
        int sum = 0;
        while(n != 0){
            sum += Math.pow(n%10,2);
            n/=10;
        }
        return sum;
    }
}
