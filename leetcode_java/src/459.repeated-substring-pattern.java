import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=459 lang=java
 *
 * [459] Repeated Substring Pattern
 */

// @lc code=start
class Solution1 {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return false;
        }

        Character startChar = s.charAt(0);
        for (int i = 1; i <= s.length() / 2; i++) {
            if (startChar.equals(s.charAt(i))) {
                if (checkRepeat(s, i)) {
                    return true;
                }
            }
        }
        return false;   
    }
    
    
    boolean checkRepeat(String s, int subLen) {
        int len = s.length();
        if (len % subLen != 0) {
            return false;
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i < len; ) {
            String subStr = s.substring(i, i + subLen);
            set.add(subStr);
            i += subLen;
        }
        return set.size() == 1;
    }
}
// @lc code=end

