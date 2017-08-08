# -*- coding:utf-8 -*-
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # 返回ListNode
    '''解题的时候需要考虑可不可以用额外空间'''
    # 这是不需要额外空间的解法，在原始链表上更改
    def ReverseList(self, pHead):
        # write code here
        pPre = None
        pMid = pHead
        pReHead = None # 翻转之后的头指针
        while pMid != None:
            pPost = pMid.next
            if pPost == None:
                pReHead = pMid
            pMid.next = pPre
            pPre = pMid
            pMid = pPost
        return pReHead
            



    # 再写一个需要额外空间的解法
    def ReverseList2(self, pHead):
        if pHead == None:
            return None

        pOld = pHead #原链表的指针
        pNew = ListNode(pHead.val) #新链表的指针
        while pOld.next != None:
            pOld = pOld.next
            tmp = ListNode(pOld.val)
            tmp.next = pNew
            pNew = tmp
        return pNew
