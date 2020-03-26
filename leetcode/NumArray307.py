class NumArray(object):

    def __init__(self, nums):
        """
        :type nums: List[int]
        """
        self.nums = nums
        

    def update(self, i, val):
        """
        :type i: int
        :type val: int
        :rtype: None
        """
        self.nums[i] = val
        

    def sumRange(self, i, j):
        """
        :type i: int
        :type j: int
        :rtype: int
        """
        sum = 0
        for num in self.nums[i:j + 1]:
            sum += num
        return sum
        
if __name__ == "__main__":
    na = NumArray([1,3,5])
    param_1 = na.sumRange(0, 2)
    print param_1
    na.update(1, 2)
    param_2 = na.sumRange(0, 2)
    print param_2

# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# obj.update(i,val)
# param_2 = obj.sumRange(i,j)