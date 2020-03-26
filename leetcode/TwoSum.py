class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        m = {}
        for i, num in enumerate(nums):
            remain = target - num;
            if remain not in m:
                m[num] = i;
            else:
                return [i, m[remain]]


if __name__ == "__main__":
    s = Solution();
    nums = [2, 7, 11, 15]
    target = 9
    print s.twoSum(nums, target)