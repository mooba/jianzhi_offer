import javax.naming.ldap.Rdn;

/*
 * @lc app=leetcode id=160 lang=java
 *
 * [160] Intersection of Two Linked Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }


        int lenA = 1, lenB = 1;
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA.next != null) {
            lenA++;
            pA = pA.next;
        }

        while(pB.next != null) {
            lenB++;
            pB = pB.next;
        }
        System.out.println("lenA" + lenA + " lenB=" + lenB);

        ListNode longList;
        ListNode shortList;
        int shortLen = 0;
        int gap = Math.abs(lenA - lenB);
        if (lenA >= lenB) {
            longList = headA;
            shortList = headB;
            shortLen = lenB;
        } else {
            longList = headB;
            shortList = headA;
            shortLen = lenA;
        }

        System.out.println("gap=" + gap + " shortLen=" + shortLen);
        while (gap > 0) {
            longList = longList.next;
            gap --;
        }
        for (int i = 0; i < shortLen; i++) {
            // if (longList.val == shortList.val) {
            //     return longList;
            // }
            if (longList.equals(shortList)) {
                return longList;
            }
            longList = longList.next;
            shortList = shortList.next;
        }

        return null;
    }



}
// @lc code=end

