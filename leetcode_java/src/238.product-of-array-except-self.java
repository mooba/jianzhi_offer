/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf2(int[] nums) {
        int[] retArray = new int[nums.length];
        int numOfZero = 0;
        int productExceptZero = 1;
        int firstZeroIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (firstZeroIndex == -1) {
                    firstZeroIndex = i;
                }
                numOfZero++;
            } else {
                productExceptZero *= nums[i];
            }
        }

        if (numOfZero >= 2) {
            return retArray;
        } else if (numOfZero == 1) {
            retArray[firstZeroIndex] = productExceptZero;
            return retArray;
        } 

        for (int i = 0; i < nums.length; i++) {
            retArray[i] = productExceptZero / nums[i];
        }
        return retArray;
    }


    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] retArray = new int[len];
        int[] prefix = new int[len];
        int[] suffix = new int[len];

        prefix[0] = 1;
        for (int i = 1; i < len; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        suffix[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums [i + 1];
        }


        for (int i = 0; i < len; i++) {
            retArray[i] = prefix[i] * suffix[i];
        }
        
        return retArray;
    }
}
// @lc code=end

