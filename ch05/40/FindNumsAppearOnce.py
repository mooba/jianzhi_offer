# -*- coding:utf-8 -*-
#####题目#####
# 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字
#####解法#####
# 这种同一个数字出现两次的题，一定要想到异或的用法，因为这种操作可以让两个相同的数为0，如果有不同的数异或之后就不能为0
# 如果只有一个数只出现一次的话直接异或之后的结果就是了，但是这里有两个，那么最后异或的结果其实就是这两个数异或的结果
# 找到这两个数异或之后的数，它二进制表示的右边第一位为1的index，按照这位是否为1把原数组分成两组，这样可以保证这两个只出现一次的数字
# 被分到不同的组。由于相同的数字肯定会分到同一组，那么每组就只有一个只出现一次的数，异或之后的结果就找到了它

class Solution:
    # 返回[a,b] 其中ab是出现一次的两个数字
    def FindNumsAppearOnce(self, array):
        # write code here
        xor_array = self.XorArray(array)
        
        firstbit1 = self.FindFirstBit1(xor_array)
        array1 = []
        array2 = []
        for elem in array:
            if self.FindFirstBit1(elem) == firstbit1:
                array1.append(elem)
            else:
                array2.append(elem)
        
        a = self.XorArray(array1)
        b = self.XorArray(array2)
        return [a, b]


    def FindFirstBit1(self, num): # 从右边开始找到数字的第一位为1的bit
        index = 1
        while num:
            if num & 1 == 1:
                return index
            else:
                num  = num >> 1
                index += 1
        return 0

    def XorArray(self, array): # 把数组中所有数字异或
        xor = array[0]
        for i in range(1, len(array)):
            xor ^= array[i]
        return xor