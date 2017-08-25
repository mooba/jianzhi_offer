# -*- coding:utf-8 -*-
class Solution:
    def LastRemaining_Solution(self, n, m):
        # write code here
        if n < 1 or m < 1:
            return -1

        numbers = [x for x in range(n)]
        i = 0
        while len(numbers) > 1:
            for j in range(1, m):
                i += 1
                if i == len(numbers):
                    i = 0
            numbers.pop(i)
            if i == len(numbers):
                i = 0

        return numbers[0]

if __name__ == "__main__":
    s = Solution()
    print s.LastRemaining_Solution(5, 3)