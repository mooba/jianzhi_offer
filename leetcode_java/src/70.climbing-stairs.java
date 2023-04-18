/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {

    //普通递归，会超时
    public int climbStairs1(int n) {
        if (n <= 2) {
            return n;
        }
        
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }

    // 斐波那契
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int a = 1;
        int b = 2;
        int tmp = 0;
        for (int i = 3; i <= n; i ++) {
            tmp = a + b;
            a = b;
            b = tmp;
        }
        return b;
    }

    

    
}
// @lc code=end

