# -*- coding:utf-8 -*-
class Solution:
    # array 二维列表
    def Find(self, target, array):
        # write code here
        m = len(array)
        n = len(array[0])
        if n == 0:
            return False
        i = 0
        j = n - 1
        while True:
            current = array[i][j]
            if current == target:
                return True
            elif target < current and j >= 0:
                j = j - 1
                continue
            elif target > current and i < m - 1:
                i = i + 1
                continue
            else:
                break
        return False

s = Solution()
array = [[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
print s.Find(7, array)