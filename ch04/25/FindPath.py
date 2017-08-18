# -*- coding:utf-8 -*-
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
import copy
class Solution:
    # 返回二维列表，内部每个列表表示找到的路径
    re = []

    def FindPath(self, root, expectNumber):
        # write code here
        if (root == None or expectNumber < root.val):
            return self.re

        currentNum = 0
        path = []
        self.FindPathRe(root, expectNumber, path, currentNum)
        return self.re

    # 因为只有前序遍历是从根节点开始的，所以使用前序遍历递归
    def FindPathRe(self, root, expectNumber, path, currentNum):
        currentNum += root.val
        path.append(root.val)

        # 路径和为输入的数并且到达叶子节点
        if (currentNum == expectNumber and root.left == None and root.right == None):
            self.re.append(copy.copy(path)) #拷贝，不然re中会随着path的pop操作变为空
            
        if (root.left and currentNum < expectNumber): # 加入后一个条件是为了剪枝
            self.FindPathRe(root.left, expectNumber, path, currentNum)

        if (root.right and currentNum < expectNumber):
            self.FindPathRe(root.right, expectNumber, path, currentNum)

        path.pop()



if __name__ == "__main__":
    #    10,5,12,4,7
    n1 = TreeNode(10)
    n2 = TreeNode(5)
    n3 = TreeNode(12)
    n4 = TreeNode(4)
    n5 = TreeNode(7)
    
    n1.left = n2
    n1.right = n3
    n2.left = n4
    n2.right = n5

    s = Solution()
    print s.FindPath(n1, 15)  # 输出[[10, 5, 4]]
    print s.FindPath(n1, 22)  # 输出[[10,5,7],[10,12]]