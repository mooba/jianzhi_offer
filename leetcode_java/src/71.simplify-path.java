import java.util.Stack;

/*
 * @lc app=leetcode id=71 lang=java
 *
 * [71] Simplify Path
 */

// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return path;
        }
        path = path.trim();

        Stack<String> stack = new Stack<>();
        String[] split = path.split("/");

        for (int i = 0; i < split.length; i++) {
            String curStr = split[i];
            if (".".equals(curStr) || "".equals(curStr)) {
                continue;
            } else if ("..".equals(curStr)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(curStr);
            }
        }

        String retPath = "";
        while (!stack.isEmpty()) {
            retPath = "/" + stack.pop() + retPath;
        }

        return retPath == "" ? "/" : retPath;
    }
}
// @lc code=end

