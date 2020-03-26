# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

import Queue
class Solution(object):
    def findBottomLeftValue(self, root):
        """
        :type root: TreeNode
        :rtype: int
        : example [2,1,3], output 1
        """
        current_node = root
        current_level = 0
        node_q = Queue.Queue()
        node_q.put((root, current_level))
        while not node_q.empty():
            (node, level) = node_q.get()
            if current_level < level:
                current_node = node
                current_level = level

            if node.left is not None:
                node_q.put((node.left, current_level + 1))
            if node.right is not None:
                node_q.put((node.right, current_level + 1))

        return current_node.val
    
if __name__ == "__main__":
    second = TreeNode(2)
    one = TreeNode(1)
    three = TreeNode(3)
    second.left = one
    second.right = three

    s = Solution()
    ret = s.findBottomLeftValue(second)
    print ret
            