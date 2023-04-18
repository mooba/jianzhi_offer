import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BinaryTree {
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

    public static void testLevelOrder() {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.right = node2;
        node2.left = node3;

        List<List<Integer>> ret = levelOrder(root);
        System.out.println(ret);
    }

    ///////////////////////////////////////////
    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Integer> nodeLevelMap = new HashMap<>();
        queue.offer(root);
        nodeLevelMap.put(root, 1);
        int max = 0;
        int currentLevelSize = 0;
        int currentLevel = 1;
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            int nodeLevel = nodeLevelMap.get(curNode);
            if (curNode.left != null) {
                queue.offer(curNode.left);
                nodeLevelMap.put(curNode.left, nodeLevel + 1);
            }
            if (curNode.right != null) {
                queue.offer(curNode.right);
                nodeLevelMap.put(curNode.right, nodeLevel + 1);
            }
            if (currentLevel != nodeLevel) {
                currentLevel++;
                max = Math.max(currentLevelSize, max);
                currentLevelSize = 1;
            } else {
                currentLevelSize++;
            }

        }

        max = Math.max(currentLevelSize, max);
        return max;
    }


    public static void testWidthOfBinaryTree() {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node33 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node9 = new TreeNode(9);

        root.left = node3;
        root.right = node2;
        node3.left = node5;
        node3.right = node33;
        node2.right = node9;

        int maxWidth = widthOfBinaryTree(root);
        System.out.println(maxWidth);
    }



    ////////////////////////////////////////////////////////////
    public static int widthOfBinaryTreeIncludeNull(TreeNode root) {
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

    public static void testWidthOfBinaryTreeIncludeNull() {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node33 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node9 = new TreeNode(9);

        root.left = node3;
        root.right = node2;
        node3.left = node5;
        node3.right = node33;
        node2.right = node9;

        int ret = widthOfBinaryTreeIncludeNull(root);
        System.out.println(ret);
    }




    ////////////////////////////////////////////////////////////
    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }


    //////////////////////////////////////////////////////////////
    // build binary tree from array
    // e.g. [5,1,4,null,null,3,6]
    public static TreeNode createTree(String str) {
        str = str.replace('[', ' ');
        str = str.replace(']', ' ');
        String[] arr = str.trim().split(",");
        return levelOrderCreateTree(arr);
    }

    private static TreeNode levelOrderCreateTree(String[] arr) {
        if (arr == null || arr.length == 0 || "null".equals(arr[0])) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(arr[0]));
        return createTree(root, 0, arr);
    }

    private static TreeNode createTree(TreeNode root, int rootIndex, String[] arr) {
        int len = arr.length;

        //生成左节点
        int leftIndex = rootIndex * 2 + 1;
        if (leftIndex >= len || "null".equals(arr[leftIndex])) {
            root.left = null;
        } else {
            Integer val = Integer.valueOf(arr[leftIndex]);
            root.left = new TreeNode(val);
            createTree(root.left, leftIndex, arr);
        }

        //生成右节点
        int rightIndex = rootIndex * 2 + 2;
        if (rightIndex >= len || "null".equals(arr[rightIndex])) {
            root.right = null;
        } else {
            Integer val = Integer.valueOf(arr[rightIndex]);
            root.right = new TreeNode(val);
            createTree(root.right, rightIndex, arr);
        }

        return root;
    }


    public static void testLevelOrderCreateTree() {
        String[] arr = {"5", "1", "4", "null", "null", "3", "6"};
        TreeNode root = levelOrderCreateTree(arr);
        preOrder(root);
    }

    public static void main(String[] args) {
        // testWidthOfBinaryTree();

        // testWidthOfBinaryTreeIncludeNull();

        testLevelOrderCreateTree();
    }

}
