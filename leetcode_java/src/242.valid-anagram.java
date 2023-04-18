/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }

        int[] charArr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';
            charArr[index] = charArr[index] + 1;
        }

        System.out.println(charArr);
        for (int i = 0; i < t.length(); i ++) {
            char c = t.charAt(i);
            int index = c - 'a';
            if (charArr[index] == 0) {
                return false;
            } else {
                charArr[index] = charArr[index] - 1;
            }
        }

        return true;
    }
}
// @lc code=end

