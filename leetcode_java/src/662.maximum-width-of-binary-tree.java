import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
 * @lc app=leetcode id=662 lang=java
 *
 * [662] Maximum Width of Binary Tree
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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<Pair> queue = new LinkedList<>();
        int curLevelStart = 1;
        int curLevelEnd = 1 ;
        int curLevel = 1;
        int max = 0;
        queue.offer(new Pair(root, 1, 1));
        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            int curNodeLevel = pair.level;
            int curNodeLevelIndex = pair.curLevelIndex;
            if (pair.node.left != null) {
                queue.offer(new Pair(pair.node.left, curNodeLevel + 1, curNodeLevelIndex * 2 - 1));
            }
            if (pair.node.right != null) {
                queue.offer(new Pair(pair.node.right, curNodeLevel + 1, curNodeLevelIndex * 2));
            }

            if (curLevel == curNodeLevel) {
                curLevelEnd = curNodeLevelIndex;
            } else {
                curLevel ++;
                max = Math.max(max, curLevelEnd - curLevelStart + 1);
                curLevelStart = curNodeLevelIndex;
                curLevelEnd = curNodeLevelIndex;
            }
        }
        
        return Math.max(max, curLevelEnd - curLevelStart + 1);
    }

    public static class Pair {
        TreeNode node;
        int level;
        int curLevelIndex;

        public Pair(TreeNode node, int level, int curLevelIndex) {
            this.node = node;
            this.level = level;
            this.curLevelIndex = curLevelIndex;
        }
    }


}
// @lc code=end

