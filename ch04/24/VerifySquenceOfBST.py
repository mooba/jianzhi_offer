# -*- coding:utf-8 -*-
class Solution:
    def VerifySquenceOfBST(self, sequence):
        # write code here
        seq_len = len(sequence)
        if seq_len == 0:
            return False
        
        tail_num = sequence[seq_len - 1]
        i = 0
        while sequence[i] < tail_num:
            i += 1
        
        j = i
        while j < seq_len -1:
            if sequence[j] < tail_num:
                return False
            j += 1
        
        left = True
        if i < seq_len -1:
            left = self.VerifySquenceOfBST(sequence[0: i + 1])
        
        right = True
        if  i < seq_len -1:
            right = self.VerifySquenceOfBST(sequence[i: seq_len - 1])

        return left and right

if __name__ == "__main__":
    lst = [5,4,3,2,1]
    lst2 = []
    s = Solution()
    print s.VerifySquenceOfBST(lst2)