# -*- coding:utf-8 -*-
'''
调整数组顺序使奇数位于偶数前面
'''
class Solution:
    def reOrderArray(self, array):
        # write code here
        array_len = len(array)
        if array_len == 0 or array_len == 1:
            return array

        odd_num = 0
        for num in array:
            if num & 0x1 == 1: 
                odd_num += 1

        odd_point = 0
        while odd_point < odd_num:
            if array[odd_point] & 0x1 == 1:
                odd_point += 1
            else:
                next_point = odd_point
                tmp1 = array[next_point]
                while tmp1 & 0x1 != 1 and next_point + 1 < array_len: 
                    tmp2 = array[next_point + 1]
                    array[next_point + 1] = tmp1
                    tmp1 = tmp2
                    next_point += 1
                array[odd_point] = tmp1
                odd_point += 1

        return array    

if __name__ == "__main__":             
    s  = Solution()
    lst = [1,2,3,4,5,6,7]
    print s.reOrderArray(lst)