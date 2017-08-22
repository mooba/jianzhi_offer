# -*- coding:utf-8 -*-
####题目#####
# 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
#####解法####
# 用数组实现一个简单的哈希表，键是字符对应的acssi，值是出现的次数

class Solution:
    def FirstNotRepeatingChar(self, s):
        # write code here
        re = -1
        if len(s) == 0:
            return re

        hashTable = [0 for i in range(256)]
        for ch in s:
            hashTable[ord(ch)] += 1

        for i in range(len(s)):
            # if hashTable[ord(s[i])] != 0:
            #     print hashTable[ord(s[i])]

            if hashTable[ord(s[i])] == 1:
                re = i
                break
        
        return re

if __name__ == "__main__":
    s  = "google"
    solu = Solution()
    print solu.FirstNotRepeatingChar(s)
            
        
