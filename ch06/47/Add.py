# -*- coding:utf-8 -*-
class Solution:
    def Add(self, num1, num2):
        # write code here
        xor = 0
        carry = 0
        while num2 != 0:
            xor = num1 ^ num2
            carry = (num1 & num2) << 1

            num1 = xor
            num2 = carry
        return num1

if __name__ == "__main__":
    num1 = 5
    num2 = 7
    s = Solution()
    print s.Add(num1, num2)