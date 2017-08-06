#-*-coding:utf8-*-
# -*- coding:utf-8 -*-
class Solution:
    def Power(self, base, exponent):
        # write code here
        if self.equal(0.0, base):
            return 0
        if 0 == exponent:
            return 1

        if exponent < 0:
            abs_exponent = -exponent
            re = self.power_with_positive_number(base, abs_exponent)
            return 1/re
        else:
            re = self.power_with_positive_number(base, exponent)
            return re
            

    def power_with_positive_number(self, base, exponent):
        if exponent == 0:
            return 1
        if exponent == 1:
            return base

        result  = self.power_with_positive_number(base, exponent>>1) ** 2 
        if exponent & 0x1 == 1: # 这里的奇偶性判断用位于运算，效率上比求与运算高
            result *= base
        
        return result

    def equal(num1, num2):
         # 判断两个浮点数是否相等
        if abs(num1 - num2) < 0.0000001:
             return True
        else:
            return False


        
        