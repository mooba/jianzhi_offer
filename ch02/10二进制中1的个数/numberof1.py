# -*- coding:utf-8 -*-
# -*- coding:utf-8 -*-
class Solution:
    def NumberOf1(self, n):
        # write code here
        if 0 == n:
            return 0
        tmp = n
        cnt = 0
        i = 0
        while i < 32:
            if tmp & 1 == 1:
                cnt += 1
            tmp = tmp >> 1
            i += 1
        return cnt