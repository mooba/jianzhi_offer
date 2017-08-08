# -*- coding:utf-8 -*-
# 操作给定的二叉树，将其变换为源二叉树的镜像
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:
    # 返回镜像树的根节点
    def Mirror(self, root):
        # write code here
        if root == None:
            return None
    
        p = root
        tmp = p.left
        p.left = p.right
        p.right = tmp
        self.Mirror(p.left)
        self.Mirror(p.right)

        return root
