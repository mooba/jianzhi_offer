# -*- coding:utf-8 -*-
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:
    # 返回构造的TreeNode根节点
    # 传入的是前序和中序的list
    def reConstructBinaryTree(self, pre, tin):
        # write code here
        pre_len = len(pre)
        tin_len = len(tin)
        if pre_len != tin_len or pre_len == 0 or tin_len == 0:
            return None

        head = TreeNode(pre[0]) #create root node
        head_index_in_tin = tin.index(head.val) # index of head in inorder lst
        
        in_left = tin[:head_index_in_tin]
        in_right = tin[head_index_in_tin+1:]
        pre_left = pre[1:head_index_in_tin+1]
        pre_right = pre[head_index_in_tin+1:]

        #recursion
        head.left = self.reConstructBinaryTree(pre_left, in_left)
        head.right = self.reConstructBinaryTree(pre_right, in_right)

        return head
