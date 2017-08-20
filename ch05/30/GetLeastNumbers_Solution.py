# -*- coding:utf-8 -*-
######题目#######
#输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,

######解法#######
# 可以用一个额外的数据结构来维护这k个数。遍历n个数，如果数据结构中的个数小于k的话，就直接放进去
# 如果数据结构中的个数等于k的话，就与数据结构中的最大数比较，如果比它小就就剔除最大数，然后把这个数插入，
# 如果它比最大数还大，就继续查看下一下
# 这个数据结构可以用堆来实现
# 这个算法的时间复杂度为nlog(k)

######推广#######
# 这道题其实是典型的topN问题，基于堆的算法很适合用于n很大k很小的海量数据的处理中
# 当内存大小不足以维护n个数的时候，用这种方法只需要维护大小为k的数据结构就可以了


#####说明#########
# 在python标准库中heapq用于实现堆这种数据结构
# heapq中提供了heapq.nlargest(k, iterable[, key])和
# heapq.nsmallest(k, iterable[, key])这种方法用于直接返回最大和最小的值
# 但调用者样的方法显然不是我们做算法题的目的
# 找最小的k个元素需要大根堆，但是heapq只实现了小根堆，所以这里需要用一个trick：
# 把所有数取反，然后用最小堆得到k个数之后再取反就得到了k个最大数


import heapq
class Solution:
    def GetLeastNumbers_Solution(self, tinput, k):
        # write code here
        output= []
        if len(tinput) < k or len(tinput) == 0 or k == 0:
            return output
        
        for elem in tinput:
            elem = - elem
            if len(output) < k:
                heapq.heappush(output, elem)
            else:
                minItem = output[0]
                if elem > minItem:
                    heapq.heapreplace(output, elem) # Pop and return the current smallest value, and add the new item
        
        return sorted([-x for x in output]) # 如果需要输出是有序的话

if __name__  == "__main__":
    input = [4,5,1,6,2,7,3,8]
    s = Solution()
    print s.GetLeastNumbers_Solution(input, 4)

