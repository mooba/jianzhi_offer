import java.util.Map;

import javax.lang.model.element.Element;

/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
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

class Main {
    public static void main(String[] args) {
        System.out.println("pengcheng");
        System.out.println(Integer.MAX_VALUE + 1);
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        // return valid(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        return valid2(root).isValidBST;
    }


    public Info valid2(TreeNode root) {
        if (root == null) {
            return new Info(true, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        }

        Info leftInfo = valid2(root.left);
        Info righInfo = valid2(root.right);

        if (leftInfo.isValidBST && leftInfo.maxValOfTree < root.val 
            && righInfo.isValidBST && righInfo.minValOfTree > root.val) {
                double currentMax = Math.max(righInfo.maxValOfTree, root.val);
                double currentMin = Math.min(leftInfo.minValOfTree, root.val);
                return new Info(true, currentMax, currentMin);
        } else {
            return new Info(false);
        }

    }


    class Info {
        boolean isValidBST;
        Double maxValOfTree;
        Double minValOfTree;

        public Info(boolean isValidBST) {
            this.isValidBST = isValidBST;
        }


        public Info(boolean isValidBST, Double maxValOfTree, Double minValOfTree) {
            this.isValidBST = isValidBST;
            this.maxValOfTree = maxValOfTree;
            this.minValOfTree = minValOfTree;
        }
    }


    public boolean valid(TreeNode node, double lowerBound, double upperBound) {
        if (node == null) {
            return true;
        }
        if (node.val <= lowerBound || node.val >= upperBound) {
            return false;
        }
        
        return valid(node.left, lowerBound, node.val) && valid(node.right, node.val, upperBound);
    }
}
// @lc code=end

