# -*- coding:utf-8 -*-
class Solution:
    def IsPopOrder(self, pushV, popV):
        # write code here
        result = False
        push_len = len(pushV)
        pop_len = len(popV)
        if push_len != pop_len:
            return result

        p1 = 0
        p2 = 0
        stack = []
        while True:
            if p1 < push_len:
                if pushV[p1] != popV[p2]:
                    stack.append(pushV[p1])
                    p1 += 1
                else:
                    p1 += 1
                    p2 += 1
            else:
                if len(stack) != 0:    
                    if stack[len(stack) - 1] == popV[p2]:
                        stack.pop()
                        p2 += 1
                    else:
                        result =  False
                        break
                else:
                    result = True
                    break

        return result  