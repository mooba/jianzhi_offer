public class ReConstructBinaryTree {
    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] vin = {4,7,2,1,5,3,8,6};

        TreeNode root = ReConstructBinaryTree.reConstructBinaryTree(pre, vin);
        System.out.println(root);

        BinaryTree.preOrder(root);
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] vin) {
        if (pre == null || vin == null || pre.length != vin.length) {
            return null;
        }
        if (pre.length == 0 || vin.length == 0) {
            return null;
        }

        return buildTreeHelper(pre, vin, 0, 0, vin.length - 1);
    }

    private static TreeNode buildTreeHelper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
    
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
    
        // int inRootIndex = inorderMap.get(rootVal);
        int inRootIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                inRootIndex = i;
                break;
            }
        }
        int leftSize = inRootIndex - inStart;
    
        root.left = buildTreeHelper(preorder, inorder, preStart + 1, inStart, inRootIndex - 1);
        root.right = buildTreeHelper(preorder, inorder, preStart + leftSize + 1, inRootIndex + 1, inEnd);
    
        return root;
    }


}
