# -*- coding:utf-8 -*-
class Solution:
    # 用递推实现，不用递归的原因是递归有重复计算，存在很大的时间复杂度开销
    def Fibonacci(self, n):
        # write code here
        f1, f2, fn= 1, 1, 0
        if n == 0:
            return fn
        if n == 1 or n == 2:
            return f1
        
        for i in range(3, n + 1):
            fn = f1 + f2
            f1, f2 = f2, fn
        return fn