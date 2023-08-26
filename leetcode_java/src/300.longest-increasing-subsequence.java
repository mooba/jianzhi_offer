/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        return LIS1(nums, nums.length);
    }

    public int LIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int retNum = 1;
        int dp[] = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
            if (dp[i] > retNum) {
                retNum = dp[i];
            }
        }
        for (int dp2 : dp) {
            System.out.print(dp2 + " ");
        }

        return retNum;
    }


    // https://leetcode.cn/problems/longest-increasing-subsequence/solution/chao-xiang-xi-tu-jie-di-gui-dong-tai-gui-hua-er-fe/
    public int LIS1(int[] nums, int n) {
        if (nums == null) {
            return 0;
        }
        return dfs(-1, 0, nums);

    }

    private int dfs(int pre, int cur, int[] nums) {
        if (cur == nums.length) {
            return 0;
        }
        int a = 0;
        int b = 0;
        // pre小于0是初始状态，继续往后判断
        // if条件满足说明是上升子序列，长度要+1
        if (pre < 0 || nums[pre] < nums[cur]) {
            a = dfs(cur, cur + 1, nums) + 1;
        }
        // 如果不满足可能是不满足上升子序列条件
        // 也可能是 满足条件但主动放弃
        b = dfs(pre, cur + 1, nums);
        return Math.max(a, b);
    }

}
// @lc code=end
