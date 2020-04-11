# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        carry = 0
        retList = ListNode(-1)
        tmp = retList
        tmp1 = l1
        tmp2 = l2
        while tmp1:
            valSum = 0
            if tmp2:
                valSum = tmp1.val + tmp2.val + carry
                tmp2 = tmp2.next
            else:
                valSum = tmp1.val + carry
            tmp1 = tmp1.next
            
            if valSum >= 10:
                carry = 1
                valSum -= 10
            else:
                carry = 0
            tmp.next = ListNode(valSum)
            tmp = tmp.next
        
        # tmp.next = tmp2
        if carry > 0:
            while tmp2:
                valSum = tmp2.val + carry
                tmp2 = tmp2.next
                if valSum >= 10:
                    valSum -= 10
                    carry = 1
                else:
                    carry = 0
                tmp.next = ListNode(valSum)
                tmp = tmp.next
            if carry > 0:
                tmp.next = ListNode(carry)
        
        return retList.next

    def addTwoNumbers2(self, l1, l2):
        retList = ListNode(-999)
        len1, len2, valSum, carry = 0, 0, 0, 0
        tmp1, tmp2, tmp = l1, l2, retList
        while tmp1:
            len1 += 1
            tmp1 = tmp1.next
        while tmp2:
            len2 += 1
            tmp2 = tmp2.next
        longList = None
        shortList = None
        if len1 >= len2:
            longList = l1
            shortList = l2
        else:
            longList = l2
            shortList = l1
        
        while longList:
            if shortList:
                valSum = longList.val + shortList.val + carry  
                shortList = shortList.next
            else: 
                valSum = longList.val + carry
            longList = longList.next
            if valSum >= 10:
                valSum -= 10
                carry = 1
            else:
                carry = 0
            tmp.next = ListNode(valSum)
            tmp = tmp.next
        
        if carry > 0:
            tmp.next = ListNode(carry)    

        return retList.next     
        

if __name__ == "__main__":
    l1 = ListNode(1)
    l2 = ListNode(9)
    l2.next = ListNode(9)
    s = Solution()
    retList = s.addTwoNumbers2(l1, l2)
    while retList:
        print retList.val
        retList = retList.next

            
            

        