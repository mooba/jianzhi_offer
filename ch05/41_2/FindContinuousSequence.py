# -*- coding:utf-8 -*-
#####题目#####
# 打印出所有和为s的连续整数序列

import copy
class Solution:
    def FindContinuousSequence(self, tsum):
        # write code here
        re = []
        start = tsum / 2 + 1
        while start > 0:
            j = start - 1
            curList = [start]
            curSum = start
            while j >= 0:
                curSum += j
                if j > 0:
                    curList.append(j)
                j -= 1
                if curSum == tsum and len(curList) > 1:
                    re.append(copy.deepcopy(sorted(curList)))
                    break
                elif curSum > tsum:
                    break
                else:
                    continue
            start -= 1
        re.sort(key=lambda x: x[0])
        return re

if __name__ == "__main__":
    s = Solution()
    print s.FindContinuousSequence(15)
                    
