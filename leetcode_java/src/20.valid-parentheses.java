import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> closeToOpenParentheses = new HashMap<>(8);
        closeToOpenParentheses.put(')', '(');
        closeToOpenParentheses.put(']', '[');
        closeToOpenParentheses.put('}', '{');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (closeToOpenParentheses.values().contains(c)) {
                stack.push(c);
            } else if (closeToOpenParentheses.keySet().contains(c)) {
                char pair = closeToOpenParentheses.get(c);
                if (stack.isEmpty() || !stack.pop().equals(pair)) {
                    return false;
                }
            } else {
                return false;
            }
        }

        if (stack.isEmpty()) {
            return true;
        } 
        return false;
    }
}
// @lc code=end

