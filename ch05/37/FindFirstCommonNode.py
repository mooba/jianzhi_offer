# -*- coding:utf-8 -*-
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None
######题目#####
# 输入两个链表，找出它们的第一个公共结点，并返回节点
######解法1####
# 先计算两个链表的长度，获得长度差距diff_len, 然后长的链表的指针先移动diff_len之后两个链表的指针一起移动，
# 直到遇到相等的就就第一个公共节点
class Solution:
    def FindFirstCommonNode(self, pHead1, pHead2):
        # write code here
        if pHead1 is None or pHead2 is None:
            return None
        
        p1 = pHead1
        p2 = pHead2
        len1 = self.getLen(p1)
        len2 = self.getLen(p2)

        if len1 > len2:
            p1 = self.walkStep(pHead1, len1 - len2)
        else:
            p2 = self.walkStep(pHead2, len2 - len1)
        
        # 齐头并进
        while p1 != p2:
                p1 = p1.next
                p2 = p2.next
        
        return p1

    def walkStep(self, pHead, step):
        p = pHead
        while step:
            p = p.next
            step -= 1
        return p

    def getLen(self, pHead):
        length = 0
        p = pHead
        while p is not None:
            length += 1
            p = p.next
        return length


#####解法2#####
# 两个指针移动两个链表之后，最终两个指针到达none节点或者公共节点
class Solution2:
    def FindFirstCommonNode(self, pHead1, pHead2):
        if pHead1 is None or pHead2 is None:
            return None

        p1 = pHead1
        p2 = pHead2
        while p1 != p2:
            if p1 is None:
                p1 = pHead2
            else:
                p1 = p1.next

            if p2 is None:
                p2 = pHead1
            else:
                p2 = p2.next
        return p1    

if __name__ == "__main__":
    l1 = ListNode(1)
    l1.next = ListNode(2)
    l1.next.next = ListNode(3)
    l6 = ListNode(6)
    l7 = ListNode(7)
    l6.next = l7
    l1.next.next.next = l6
    
    l2 = ListNode(4)
    l2.next = ListNode(5)
    l2.next.next = l6

    solu = Solution2()
    p = solu.FindFirstCommonNode(l1, l2)
    while p is not None:
        print p.val
        p = p.next