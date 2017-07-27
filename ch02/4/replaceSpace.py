# -*- coding:utf-8 -*-

class Solution:
    # s 源字符串
    def replaceSpace(self, s):
        # write code here
        old_length = len(s) # raw length of the str
        num_space = s.count(' ') # number of space

        new_s = [' ' for i in range(old_length + 2*num_space)]
        i = old_length - 1
        j = len(new_s) - 1
        while i >=0 and i <= j:
            if s[i] == ' ':
                new_s[j] = '0'
                new_s[j - 1] = '2'
                new_s[j - 2] = '%'
                j = j - 3
            else:
                new_s[j] = s[i]
                j -= 1
            i -= 1
        return ''.join(new_s)

if __name__ == '__main__':
    s = Solution()
    print s.replaceSpace("bai peng")
        