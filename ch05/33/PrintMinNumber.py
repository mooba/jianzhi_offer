# -*- coding:utf-8 -*-
class Solution:
    def PrintMinNumber(self, numbers):
        # write code here
        re = ""
        if len(numbers) == 0:
            return re

        sorted_numbers = sorted(numbers, self.comp)
        for ele in sorted_numbers:
            re += str(ele)
        return re

    def comp(self, a, b):
        str1 = str(a) + str(b)
        str2 = str(b) + str(a)
        return cmp(str1, str2)


if __name__ == "__main__":
    input = [3, 32, 321]
    s = Solution()
    print s.PrintMinNumber(input)
    