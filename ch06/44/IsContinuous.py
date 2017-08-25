#####题目#####
# 从牌中随机抽五张，判断是不是顺子，其中大小王可看成任意数字(这里没有说只有一副牌)
#####解法#####
# 步骤：
# 1.对数组排序
# 2.统计数组中0的个数（用0代表大小王）
# 3.统计排序后相邻数字之间的空缺数
# 如果0的个数大于空缺数，则可以构成顺子
# 注意，不能出现对子，否则不能构成顺子


# -*- coding:utf-8 -*-
class Solution:
    def IsContinuous(self, numbers):
        # write code here
        if len(numbers) == 0:
            return False

        zeroNum = 0 # 0的数目
        padNum = 0 # 间隔数目
        sortedNum = sorted(numbers)
        for i in range(len(sortedNum)):
            if sortedNum[i] == 0:
                zeroNum += 1
            if i + 1 < len(sortedNum) and sortedNum[i] != 0:
                padNum = padNum + sortedNum[i + 1] - sortedNum[i] - 1
                if sortedNum[i] == sortedNum[i + 1]:
                    return False
        if padNum <= zeroNum:
            return True
        else:
            return False
        