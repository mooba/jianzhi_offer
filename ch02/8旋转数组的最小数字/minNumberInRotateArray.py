# -*- coding:utf-8 -*-
class Solution:
    def minNumberInRotateArray(self, rotateArray):
        # write code here
        array_len = len(rotateArray)
        if array_len == 0:
            return 0
        if array_len == 1:
            return rotateArray[0]
        
        start = 0
        end = array_len - 1
        mid = 0

        # 使用二分查找，时间复杂度为log(n)
        while rotateArray[start] >= rotateArray[end]:
            if end - start == 1: # 说明两个指针相邻，end所指就是我们所寻
                mid = end
                break
            
            mid = (start + end) / 2
            if rotateArray[start] == rotateArray[mid] \
                and rotateArray[end] == rotateArray[mid]:
                return min(rotateArray)
            if rotateArray[mid] >= rotateArray[end]:
                start = mid
            else:
                end = mid

        return rotateArray[mid] 
