# -*- coding:utf-8 -*-
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def FindKthToTail(self, head, k):
        # write code here
        if head == None or k <=0:
            return

        p1 = head
        p2 = head
        for i in range(k - 1): # p1指向第k个数
            if p1.next != None:
                p1 = p1.next
            else:
                return None

        while p1.next != None:
            p1 = p1.next
            p2 = p2.next

        return p2.val  
if __name__ == '__main__':    
    # 假设输入为[1,2,3,4,5],5
    # 输出为1
    node = ListNode(5)
    for i in [4,3,2,1]:
        tmp = ListNode(i)
        tmp.next = node
        node = tmp

    s = Solution()
    print s.FindKthToTail(node, 5)
                
