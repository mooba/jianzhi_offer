# 从上往下打印出二叉树的每个节点，同层节点从左至右打印
# -*- coding:utf-8 -*-
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:
    # 返回从上到下每个节点值列表，例：[1,2,3]
    def PrintFromTopToBottom(self, root):
        # write code here
        re_lst = [] 
        queue = [] # 用列表作为队列
        if root == None:
            return re_lst

        queue.append(root)
        while len(queue) != 0:
            tmp = queue[0]
            if tmp.left:
                queue.append(tmp.left)
            if tmp.right:
                queue.append(tmp.right)
            re_lst.append(tmp.val)
            queue.pop(0)
        
        return re_lst

