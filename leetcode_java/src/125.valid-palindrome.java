/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        
        char[] charArr = s.toLowerCase().toCharArray();
        System.out.println(charArr);
        
        int i = 0;
        int j = charArr.length - 1;
        while(i < j) {
            while(!isValidChar(charArr[i]) && i < j) {
                i ++;
            }

            while(!isValidChar(charArr[j]) && i < j) {
                j--;
            }

            if(charArr[i] == charArr[j]) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    boolean isValidChar(char c) {
        if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
            return true;
        }
        return false;
    }

}
// @lc code=end
