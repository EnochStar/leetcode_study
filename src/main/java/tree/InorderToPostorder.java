package tree;

/**
 * @author FL8000
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder =[9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 */
public class InorderToPostorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    public TreeNode build(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd) {
        if(pStart > pEnd) {
            return null;
        }
        int rootVal = postorder[pEnd];
        int index = -1;
        for(int i = iStart;i <= iEnd;i++) {
            if(inorder[i] == rootVal) {
                index = i;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        int leftSize = index - iStart;
        root.left = build(inorder, iStart, index - 1, postorder, pStart, pStart + leftSize - 1);
        root.right = build(inorder, index + 1, iEnd, postorder, pStart + leftSize, pEnd - 1);
        return root;
    }
}
