/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ret = {-1, -1};
        if (nums.length == 0) {
            return ret;
        }

        int targetIndex = searchHelper(nums, 0, nums.length - 1, target);
        if (targetIndex == -1) {
            return ret;
        }
        System.out.println(targetIndex);
        int i = targetIndex, j = targetIndex;
        while (i >= 0 && nums[i] == target)
            i--;
        while (j < nums.length && nums[j] == target)
            j++;
        
        ret[0] = i + 1;
        ret[1] = j - 1;
        return ret;
    }

    public int searchHelper(int[] nums, int left, int right, int target) {
        if (left > right || left < 0 || right >= nums.length) {
            return -1;
        }
        while (left <= right) {
            int mid = (right + left) >> 1;
            if (target == nums[mid]) {
                return mid;
            }
            if (target > nums[mid]) {
                return searchHelper(nums, mid + 1, right, target);
            } else {
                return searchHelper(nums, left, mid - 1, target);
            }
        }
        return -1;
    }

    public int[] searchRange1(int[] nums, int target) {
        int[] ret = {-1, -1};
        if (nums.length == 0) {
            return ret;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (ret[0] == -1) {
                    ret[0] = i;
                    ret[1] = i;
                } else {
                    ret[1] = i;
                }
            }
        }
        
        return ret;
    }
}
// @lc code=end

