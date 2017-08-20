# -*- coding:utf-8 -*-
# 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
# 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
# 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
# 如果不存在则输出0
class Solution:
    # 返回超过一半的数字,不存在则输出0
    def MoreThanHalfNum_Solution(self, numbers):
        # write code here
        if len(numbers) == 0:
            return 0
        
        count = 1
        num = numbers[0]
        for i in range(1, len(numbers)):
            if numbers[i] != num:
                if count > 0:
                     count -= 1
                elif count == 0 :
                    num = numbers[i]
            else:
                count += 1
        
        if count > 0:
            return num
        else:
            return 0

if __name__ == "__main__":
    # numbers = [1,2,3,2,2,2,5,4,2]
    # numbers = [2,2,2,2,2,1,3,4,5]
    numbers = [1,2,3,2,4,2,5,2,3]
    s = Solution()
    print s.MoreThanHalfNum_Solution(numbers)
        
