class Solution(object):
    def checkSubarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        : [23, 2, 4, 6, 7],  k=6
        """
        if len(nums) < 2:
            return False
        for i in range(len(nums)):
            curr_sum = nums[i]
            for j in range(i + 1, len(nums)):
                curr_sum += nums[j];
                if curr_sum == 0:
                    return True
                if k == 0:
                    break
                if curr_sum % k == 0:
                    return True
        return False


            

    def checkSubarraySum2(self, nums, k):
        for i in range(1, len(nums)):
            nums[i] += nums[i - 1]

        print nums
        
        hm = {0: -1}
        for i in range(len(nums)):
            tmp = nums[i]
            if k:
                tmp %= k
            if tmp in hm:
                if i - hm[tmp] >= 2:
                    print nums[i]
                    print hm[tmp]
                    return True
            else:
                hm[tmp] = i
        return False


if __name__ == "__main__":
    s = Solution()
    nums = [6, 12,13,34,56]
    k = 6
    ret = s.checkSubarraySum2(nums, k)
    print ret


