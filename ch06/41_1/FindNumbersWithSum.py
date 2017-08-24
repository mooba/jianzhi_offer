#####题目#####
# 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
# 提示：乘积最小的其实就是最开始遇到的
# -*- coding:utf-8 -*-
class Solution:
    def FindNumbersWithSum(self, array, tsum):
        # write code here
        re = []
        arrLen = len(array)
        if arrLen == 0 or tsum <= array[0]:
            return re

        start = 0
        end = arrLen - 1
        while start < end:
            curSum = array[start] + array[end]
            if  curSum == tsum:
                re = [array[start], array[end]]
                break
            elif curSum < tsum:
                start += 1
            else:
                end -= 1
        return re
