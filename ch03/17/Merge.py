# -*- coding:utf-8 -*-
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
class Solution:
    # 返回合并后列表，同样可以考虑需不需要额外空间的解法
    def Merge(self, pHead1, pHead2):
        # write code here
        if pHead1 == None:
            return pHead2
        if pHead2 == None:
            return pHead1

        if pHead1.val <= pHead2.val:
            pHead = pHead1
            p = pHead
            p1 = pHead1.next
            p2 = pHead2
        else:
            pHead = pHead2
            p = pHead
            p2 = pHead2.next
            p1 = pHead1
        
        while p1 and p2:
            if p1.val <= p2.val:
                p.next = p1
                p = p.next
                p1 = p1.next
            else:
                p.next = p2
                p = p.next
                p2 = p2.next
        
        if p1 == None:
            p.next = p2
        if p2 == None:
            p.next = p1
        
        return pHead