/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int curMin = prices[0];
        int curMaxDiff = prices[1] - prices[0];
        for (int i = 2; i < prices.length; i++) {
            if (prices[i - 1] < curMin) {
                curMin = prices[i - 1];
            }
            if (prices[i] - curMin > curMaxDiff) {
                curMaxDiff = prices[i] - curMin;
            }
        }
        
        return curMaxDiff;
    }
}
// @lc code=end

