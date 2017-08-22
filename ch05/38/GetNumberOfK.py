# -*- coding:utf-8 -*-
class Solution:
    def GetNumberOfK(self, data, k):
        # write code here
        if len(data) == 0:
            return 0;

        startK = self.GetFirstK(data, k) # 返回重复数字出现的第一个位置
        endK = self.GetLastK(data, k)
        
        print "start:", startK
        print "end:",endK
        if startK == -1 or endK == -1:
            return 0
        
        num = endK - startK + 1        
        return num
    
    def GetFirstK(self, data, k):
        if len(data) == 0:
            return -1
        
        start = 0
        end = len(data) - 1
        while start <= end:
            mid = (start + end) >> 1
            if data[mid] == k:
                if mid == 0 or (mid > 0 and data[mid - 1] != k):
                    return mid
                else:
                    end = mid - 1
            elif data[mid] < k:
                start = mid + 1
            else:
                end = mid - 1
        return -1
    
    def GetLastK(self, data, k):
        if len(data) == 0:
            return -1

        start = 0
        end = len(data) - 1
        while start <= end:
            mid = (start + end)>>1
            if data[mid] == k:
                if mid == len(data) - 1 or (mid < len(data) and data[mid + 1] != k):
                    return mid
                else:
                    start = mid + 1
            elif data[mid] < k:
                start = mid + 1
            else:
                end = mid - 1
        return -1

if __name__ == "__main__":
    # data = [1,2,4,4,4,5,6,7]
    # data = [1,2,3,3,3,3]
    data = [3,3,3,3,4,5]
    solu = Solution()
    print "k出现的次数为：", solu.GetNumberOfK(data, 3)
                
                