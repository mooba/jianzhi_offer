import java.util.List;

/*
 * @lc app=leetcode id=572 lang=java
 *
 * [572] Subtree of Another Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    /**
     * 这种通过
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree1(TreeNode s, TreeNode t) {
        // 如果目标子树为空，则它是任何二叉树的子树
        if (t == null) {
            return true;
        }
        // 如果原二叉树为空，则它没有子树
        if (s == null) {
            return false;
        }
        // 对原二叉树和目标子树分别进行后序遍历和中序遍历
        String sPostorder = postorderTraversal(s);
        String sInorder = inorderTraversal(s);
        String tPostorder = postorderTraversal(t);
        String tInorder = inorderTraversal(t);
        // 判断目标子树的后序遍历结果是否是原二叉树后序遍历结果的子串，
        // 同时判断目标子树的中序遍历结果是否是原二叉树中序遍历结果的子串
        return sPostorder.contains(tPostorder) && sInorder.contains(tInorder);
    }
    
    // 后序遍历
    private String postorderTraversal(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(postorderTraversal(root.left));
        sb.append(postorderTraversal(root.right));
        sb.append(root.val);
        return sb.toString();
    }
    
    // 中序遍历
    private String inorderTraversal(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(inorderTraversal(root.left));
        sb.append(root.val);
        sb.append(inorderTraversal(root.right));
        return sb.toString();
    }
    


    public boolean isSubtree2(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        if (subRoot == null) {
            return true;
        }

        if (isSameTree(root, subRoot)) {
            return true;
        } else {
            return isSameTree(root.left, subRoot) || isSameTree(root.right, subRoot);
        }

    }


    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }

        return (root1.val == root2.val) 
                && isSameTree(root1.left, root2.left)
                && isSameTree(root1.right, root2.right);
    }
}
// @lc code=end

