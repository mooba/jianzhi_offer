import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Element;

/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
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


    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricHelper(root.left, root.right);
    }

    public boolean isSymmetricHelper(TreeNode leftTree, TreeNode rightTree) {
        if (leftTree == null && rightTree == null) {
            return true;
        }
        if (leftTree == null || rightTree == null) {
            return false;
        }
        if (leftTree.val != rightTree.val) {
            return false;
        }
        return isSymmetricHelper(leftTree.left, rightTree.right) 
                && isSymmetricHelper(leftTree.right, rightTree.left);
    }


    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<String> inOrderList = new ArrayList<>();
        List<String> inOrderReverseList = new ArrayList<>();
        inOrder(root, inOrderList, true);
        inOrderReverse(root, inOrderReverseList, false);
        
        // System.out.println(inOrderList);
        // System.out.println(inOrderReverseList);
        for (int i = 0; i < inOrderList.size(); i++) {
            String[] tmp1 = inOrderList.get(i).split("_");
            String[] tmp2 = inOrderReverseList.get(i).split("_");
            if (tmp1[0].equals(tmp2[0]) && !tmp1[1].equals(tmp2[1])) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }



    /**
     * 
     * @param root
     * @param inOrderList
     * @param left 自己是父节点的左还是右节点
     */
    public void inOrder(TreeNode root, List<String> inOrderList, boolean left) {
        if (root == null) {
            return;
        }

        inOrder(root.left, inOrderList, true);
        String listItem = root.val + "_";
        if (left) {
            listItem = listItem +  "left";
        } else {
            listItem = listItem + "right";
        }
        inOrderList.add(listItem);
        inOrder(root.right, inOrderList, false);
    }


    public void inOrderReverse(TreeNode root, List<String> inOrderReverseList, boolean left) {
        if (root == null) {
            return;
        }

        inOrderReverse(root.right, inOrderReverseList, false);
        String listItem = root.val + "_";
        if (left) {
            listItem = listItem +  "left";
        } else {
            listItem = listItem + "right";
        }
        inOrderReverseList.add(listItem);
        inOrderReverse(root.left, inOrderReverseList, true);
    }

}
// @lc code=end

