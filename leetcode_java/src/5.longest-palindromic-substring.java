/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.trim().length() == 0) {
            return "";
        }

        String maxString = s.substring(0, 1);
        int len = s.length();
        for(int i = 0; i < len; i++) {
            int start = i;
            int end = len - 1;
            int subLen = end - start + 1;
            if (subLen < maxString.length()) {
                break;
            }
            while (end > start) {
                if (checkPalindrom(s, start, end)) {
                    if (end - start + 1 > maxString.length()) {
                        maxString = s.substring(start, end + 1);
                        // System.out.println(maxString);
                    }
                    break;
                } else {
                    end--;
                }
            }
            
        }
        
        return maxString;
    }
    
    private boolean checkPalindrom(String s, int start, int end) {
        if (start > end) {
            if (start == end + 1) {
                return true;
            } else {
                return false;
            }
        } else if (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                return checkPalindrom(s, start + 1, end - 1);
            } else {
                return false;
            }
        } else {
            return true;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("cbcbd"));
        // System.out.println(solution.longestPalindrome("a"));
        // System.out.println(solution.longestPalindrome("abac"));
    }
}
// @lc code=end


