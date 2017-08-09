# -*- coding:utf-8 -*-
# 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
class Solution:
    # matrix类型为二维列表，需要返回列表
    def printMatrix(self, matrix):
        # write code here
        re_list = []
        rows = len(matrix)
        cols = len(matrix[0])
        if 0 == rows or 0 == cols:
            return re_list
        start = 0

        while rows > start * 2 and cols > start * 2:
            re_list.extend(self.getNumbersInCircle(matrix, rows, cols, start))
            start += 1
        return re_list

    def getNumbersInCircle(self, matrix, rows, cols, start):
        re = []
        sub_rows = rows - 2 * start # 需要经过的行数
        sub_cols  = cols - 2 * start
        
        # 从左往右
        for i in range(sub_cols):
            re.append(matrix[start][start + i])
        
        # 从上往下
        if sub_rows >=2:
            for i in range(1, sub_rows):
                re.append(matrix[start + i][start + sub_cols - 1])
        
        # 从右往左
        if sub_rows >= 2 and  sub_cols >= 2:
            for i in range(start + sub_cols - 2, start - 1, -1):
                re.append(matrix[start + sub_rows - 1][i])

        # 从下往上
        if sub_rows > 2 and sub_cols >=2:
            for i in range(start + sub_rows - 2, start, -1):
                re.append(matrix[i][start])
        
        return re

if __name__ == '__main__':
    m = [[1,2,3,4], [5,6,7,8], [9,10,11,12], [13,14,15,16]]
    m2 = [[1],[2],[3],[4],[5]]
    s = Solution()
    print s.printMatrix(m2) 

