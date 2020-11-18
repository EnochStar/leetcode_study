package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FL8000
 * 给你 root1 和 root2 这两棵二叉搜索树。
 *
 * 请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。
 * （输入为前序遍历）
 * 输入：root1 = [2,1,4], root2 = [1,0,3]
 * 输出：[0,1,1,2,3,4]
 * 示例 2：
 *
 * 输入：root1 = [0,-10,10], root2 = [5,1,7,0,2]
 * 输出：[-10,0,0,1,2,5,7,10]
 * 示例 3：
 *
 * 输入：root1 = [], root2 = [5,1,7,0,2]
 * 输出：[0,1,2,5,7]
 * 示例 4：
 *
 * 输入：root1 = [0,-10,10], root2 = []
 * 输出：[-10,0,10]
 *
 * 链接：https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees
 */
public class AllElementsInTwoBinarySearchTrees {
    List<Integer> list = new ArrayList();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> arr1 = new ArrayList();
        List<Integer> arr2 = new ArrayList();
        dfs(root1,arr1);
        dfs(root2,arr2);
        return merge(arr1,arr2);
    }
    public void dfs(TreeNode root,List<Integer> list) {
        if(root == null) {
            return;
        }
        dfs(root.left,list);
        list.add(root.val);
        dfs(root.right,list);
    }
    public List<Integer> merge(List<Integer> list1, List<Integer> list2){
        List<Integer> res = new ArrayList();
        int idx1 = 0;
        int idx2 = 0;
        int size1 = list1.size();
        int size2 = list2.size();
        for(;idx1 < size1 && idx2 < size2;) {
            if(list1.get(idx1) < list2.get(idx2)) {
                res.add(list1.get(idx1));
                idx1++;
            }else{
                res.add(list2.get(idx2));
                idx2++;
            }
        }
        while(idx1 < size1){
            res.add(list1.get(idx1));
            idx1++;
        }
        while(idx2 < size2){
            res.add(list2.get(idx2));
            idx2++;
        }
        return res;
    }
}
