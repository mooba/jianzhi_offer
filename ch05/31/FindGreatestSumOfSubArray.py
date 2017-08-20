# -*- coding:utf-8 -*-
class Solution:
    def FindGreatestSumOfSubArray(self, array):
        # write code here
        arr_len = len(array)
        if arr_len == 0:
            return 0

        i = 0
        ret_sum = array[0]
        cur_sum = 0
        for i in range(arr_len):
            if cur_sum <= 0:
                cur_sum = array[i]
            else:
                cur_sum += array[i]
            
            if cur_sum >= ret_sum:
                ret_sum = cur_sum
        
        return ret_sum

if __name__ == "__main__":
    # input = [1, -2, 3, 10, -4, 7, 2, -5] # output 18
    # input = [-2,-8,-1,-5,-9] # output -1
    input = [2,8,1,5,9]  # output 25
    s = Solution()
    print s.FindGreatestSumOfSubArray(input)