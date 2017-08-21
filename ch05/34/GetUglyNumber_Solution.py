# -*- coding:utf-8 -*-
#####题目######
# 把只包含因子2、3和5的数称作丑数（Ugly Number）。
# 例如6、8都是丑数，但14不是，因为它包含因子7。 习惯上我们把1当做是第一个丑数。
# 求按从小到大的顺序的第N个丑数

#####解法#####
# m2代表乘以二刚好大于当前最大值的丑数的index
# m3代表乘以3刚好大于当前最大值的丑数的index

class Solution: 
    def GetUglyNumber_Solution(self, index):
        # write code here
        ugly_num = [1]
        if index <= 0:
            return 0
            
        ugly_len = 1
        m2 = m3 = m5 = 0
        while ugly_len < index:
            cur_max = ugly_num[-1]
            while ugly_num[m2] * 2 <= cur_max:
                m2 += 1
            while ugly_num[m3] * 3 <= cur_max:
                m3 += 1
            while ugly_num[m5] * 5 <= cur_max:
                m5 += 1

            min_of_m = min([ugly_num[m2] * 2, ugly_num[m3] * 3, ugly_num[m5] * 5])
            ugly_num.append(min_of_m)
            ugly_len += 1

        print ugly_num
        return ugly_num[index - 1]

if __name__ == "__main__":
    s = Solution()
    print s.GetUglyNumber_Solution(11)