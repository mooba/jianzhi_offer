import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() <= 1) {
            return s.length();
        }

        // int left;
        int maxLen = 0;
        int maxLeft = 0;
        int maxRight = 0;
        for (int i = 0; i < s.length(); ) {
            int right = i;
            Map<Character, Integer> map = new HashMap<>();
            while(right < s.length()) {
                if (map.get(s.charAt(right)) != null) {
                    int index = map.get(s.charAt(i));
                    i = index + 1;
                    break;
                } else {
                    map.put(s.charAt(right), i);
                    if (right - i + 1 > maxLen) {
                        maxLen = right - i + 1;
                        maxLeft = i;
                        maxRight = right;
                    }
                    right++;
                }
            }
            if (right == s.length()) {
                break;
            }
        }

        System.out.println(s.substring(maxLeft, maxRight + 1));
        return maxLen;
    }
}
// @lc code=end

