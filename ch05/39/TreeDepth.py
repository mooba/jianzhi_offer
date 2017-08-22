# -*- coding:utf-8 -*-
#####题目#####
# 输入一棵二叉树，求该树的深度。
# 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度
# 此题和“求二叉树的最长路径”是同样的意思

# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:
    def TreeDepth(self, pRoot):
        # write code here
        if pRoot is None:
            return 0

        leftDepth = 1 + self.TreeDepth(pRoot.left)

        rightDepth = 1 + self.TreeDepth(pRoot.right)
        
        re = leftDepth if leftDepth > rightDepth else rightDepth
        return re
        