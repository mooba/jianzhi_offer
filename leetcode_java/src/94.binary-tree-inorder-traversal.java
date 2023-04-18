import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> retList = new ArrayList<>();
        if (root == null) {
            return retList;
        }

        inorderTraversalWithList(root, retList);
        return retList;
    }


    void inorderTraversalWithList(TreeNode root, List<Integer> retList) {
        if (root == null) {
            return;
        }

        inorderTraversalWithList(root.left, retList);
        retList.add(root.val);
        inorderTraversalWithList(root.right, retList);
    }
}
// @lc code=end

