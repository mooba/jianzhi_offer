import java.util.Arrays;

/*
 * @lc app=leetcode id=1143 lang=java
 *
 * [1143] Longest Common Subsequence
 */

// @lc code=start
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) {
            return 0;
        }

        return process(text1.toCharArray(), text2.toCharArray());
    }


    public int process(char[] arr1, char[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[][] dp = new int[len1][len2];

        dp[0][0] = arr1[0] == arr2[0] ? 1 : 0;
        for (int i = 1; i < len2; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], arr1[0] == arr2[i] ? 1 : 0);
            // dp[0][i] = (arr1[0] == arr2[i] || (i >= 1 && dp[0][i - 1] == 1)) ?  1 : 0;
        }
        for (int j = 1; j < len1; j++) {
            dp[j][0] = Math.max(dp[j - 1][0], arr1[j] == arr2[0] ? 1 : 0);
            // dp[j][0] = (arr1[j] == arr2[0] || (j >= 1) && dp[j - 1][0] == 1) ? 1 : 0;
        }

        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (arr1[i] == arr2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], 
                        Math.max(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }

        return dp[len1 - 1][len2 - 1];
    }
}
// @lc code=end

