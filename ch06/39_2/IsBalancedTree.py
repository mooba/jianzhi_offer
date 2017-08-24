#####题目#####
# 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
# 所谓平衡二叉树是指任意节点的左右子树的深度相差不超过1

#####解法1######
# 从上往下，先判断根节点是否平衡，然后再依次判断左右子树是否平衡
# 但是这种方式会导致重复节点被重复遍历，效率不高

#####解法2#####
# 用后序遍历的方式遍历二叉树，这种方式是从下向上的顺序求子树的高度

# -*- coding:utf-8 -*-
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:
    is_balanced = True
    def IsBalanced_Solution(self, pRoot):
        # write code here
        self.IsBalanced(pRoot)
        return self.is_balanced

    def IsBalanced(self, root):
        if root is None:
            return 0
        
        leftDepth = 1 + self.IsBalanced(root.left)
        rightDepth = 1 + self.IsBalanced(root.right)

        if abs(leftDepth - rightDepth) > 1:
            self.is_balanced = False

        return leftDepth if leftDepth > rightDepth else rightDepth