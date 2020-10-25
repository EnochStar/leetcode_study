package offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author FL8000
 * ÌâÄ¿ÃèÊö
 */
public class NumberThirtyOne {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque();
        int j = 0;
        for(int elem : pushed){
            stack.push(elem);
            while(j < popped.length && !stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
        }
        return j == popped.length;
    }
}
