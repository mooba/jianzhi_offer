# -*- coding:utf-8 -*-
class Solution:
    re = set() # 保存不重复元素
    def Permutation(self, ss):
        # write code here
        if 0 == len(ss):
            return self.re
        
        ss_list = list(ss) # string 在python 中是不可变对象，不能对单个字符赋值，所以要转换成list
        self.PermutationRe(ss_list, 0)
        return list(self.re)

    def PermutationRe(self, ss_list, start):
        if start > len(ss_list) - 1:
            self.re.add("".join(ss_list))
        else:
            i = start
            while i < len(ss_list):
                ss_list[start], ss_list[i] = ss_list[i], ss_list[start]  # 交换位置
                self.PermutationRe(ss_list, start + 1)
                ss_list[start], ss_list[i] = ss_list[i], ss_list[start]  # 交换回来
                i += 1

if __name__ == "__main__":
    ss1 = "aaa"
    s1 = Solution()
    print s1.Permutation(ss1)

    # ss2 = "abc"
    # s2 = Solution()
    # print s2.Permutation(ss2)
                

