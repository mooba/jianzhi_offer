import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;


/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {


    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> retList = new ArrayList<>();

        if (root == null) {
            return retList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Integer> nodeLevel = new HashMap<>();
        queue.offer(root);
        nodeLevel.put(root, 1);
        int currentLevel = 1;
        List<Integer> levelList = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            if (currentLevel != nodeLevel.get(curNode)) {
                currentLevel++;
                retList.add(levelList);
                levelList = new ArrayList<>();
            }
            levelList.add(curNode.val);
            
            if (curNode.left != null) {
                queue.offer(curNode.left);
                nodeLevel.put(curNode.left, currentLevel + 1);
            }
            if (curNode.right != null) {
                queue.offer(curNode.right);
                nodeLevel.put(curNode.right, currentLevel + 1);
            }
            
        }
        if (levelList.size() != 0) {
            retList.add(levelList);
        }

        return retList;
    }


    

    public static void main(String[] args) {
        System.out.println("hello");
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        List<List<Integer>> outterList = new ArrayList<>();

        outterList.add(list);
        list = new ArrayList<>();
        System.out.println(outterList);
    }
}
// @lc code=end
