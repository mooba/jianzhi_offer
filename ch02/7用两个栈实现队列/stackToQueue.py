    # -*- coding:utf-8 -*-
# python中是用list来表示栈这种数据结构的
class Solution:
    def __init__(self):
        self.stack1 = []
        self.stack2 = []

    def push(self, node):
        # write code here
        while len(self.stack2) != 0:
            tmp = self.stack2.pop()
            self.stack1.append(tmp)
        self.stack1.append(node)

    def pop(self):
        # return xx
        while len(self.stack1) != 0:
            tmp = self.stack1.pop()
            self.stack2.append(tmp)
        return self.stack2.pop()