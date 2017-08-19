# -*- coding:utf-8 -*-
class RandomListNode:
    def __init__(self, x):
        self.label = x
        self.next = None
        self.random = None

class Solution:
    # 返回 RandomListNode
    def Clone(self, pHead):
        # write code here
        if pHead == None:
            return None

        p = pHead
        while p:
            newNode = RandomListNode(p.label)
            newNode.next = p.next
            p.next = newNode
            p = newNode.next

        p = pHead
        # newP = p.next
        while p:
            newP = p.next
            if p.random:
                newP.random = p.random.next
            p = newP.next
        
        p = pHead
        newP = pHead.next
        newHead = pHead.next
        while newP.next:
            p.next = newP.next
            p = p.next
            newP.next = p.next
            newP = newP.next
        p.next = None

        return newHead

if __name__ == "__main__":
    # {1,2,3,4,5,3,5}
    n1 = RandomListNode(1)
    n2 = RandomListNode(2)
    n3 = RandomListNode(3)
    n4 = RandomListNode(4)
    n5 = RandomListNode(5)
    n1.next = n2
    n1.random = n3
    n2.next = n3
    n3.next = n4
    n4.next = n5
    n4.random = n2

    n = n1
    print "row list:"
    while n:
        print n.label
        n = n.next

    s = Solution()
    copy = s.Clone(n1)
    tmp = copy
    print "copy list:"
    while (tmp):
        print tmp.label
        tmp = tmp.next