# -*- coding:utf-8 -*-
class Solution:
    def ReverseSentence(self, s):
        # write code here
        s_lst = s.split(" ")
        for i in range(len(s_lst)):
            s_lst[i] = s_lst[i][::-1]
        
        return "".join(s_lst)[::-1]
