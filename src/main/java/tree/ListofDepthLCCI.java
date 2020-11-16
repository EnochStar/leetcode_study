package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author FL8000
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[1,2,3,4,5,null,7,8]
 * <p>
 * 1
 * /  \
 * 2    3
 * / \    \
 * 4   5    7
 * /
 * 8
 * <p>
 * 输出：[[1],[2,3],[4,5,7],[8]]
 * <p>
 * 链接：https://leetcode-cn.com/problems/list-of-depth-lcci
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class ListofDepthLCCI {
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) {
            return new ListNode[0];
        }
        int h = 0;
        return bfs(tree);
    }

    public ListNode[] bfs(TreeNode tree) {
        LinkedList<TreeNode> queue = new LinkedList();
        queue.offer(tree);
        List<ListNode> list = new ArrayList();
        ListNode dummy = new ListNode(-1);
        while (!queue.isEmpty()) {
            int count = queue.size();
            ListNode cur = dummy;
            while (count > 0) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
                cur.next = new ListNode(temp.val);
                cur = cur.next;
                count--;
            }
            list.add(dummy.next);
        }
        ListNode[] res = new ListNode[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
