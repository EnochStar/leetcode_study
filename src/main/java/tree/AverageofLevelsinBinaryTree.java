package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AverageofLevelsinBinaryTree {
    List<Double> list = new ArrayList();
    public List<Double> averageOfLevels(TreeNode root) {
        levelOrder(root);
        return list;
    }
    public void levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()){
            double num = queue.size();
            double count = num;
            double sum = 0;
            while(num > 0){
                TreeNode cur = queue.poll();
                sum += cur.val;
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
                num--;
            }
            list.add((double) (sum/count));
        }
    }
}
