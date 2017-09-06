/*
struct ListNode {
    int val;
    struct ListNode *next;
    ListNode(int x) :
        val(x), next(NULL) {
    }
};
*/
/***********
题目：
一个链表中包含环，请找出该链表的环的入口结点。没有入口就返回NULL。
***********/
class Solution {
public:
    /*解法一
    用快慢指针，如果能够相遇说明有环。
    然后慢指针不动，把快指针重新移到表头再和慢指针以同样的速度移动（一次一步）
    当它们再次相遇的时候所在的节点就是环的入口
    */
    ListNode *EntryNodeOfLoop(ListNode *head) {
        if (head == NULL || head->next == NULL)
            return NULL;
        ListNode *slow = head;
        ListNode *fast = head;
        bool hasCycle = false;
        while (fast->next != NULL && fast->next->next != NULL) {
            slow = slow->next;
            fast = fast->next->next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        if (hasCycle == false)
            return NULL;

        fast = head; // 快慢指针相遇之后把快指针移到表头
        while (fast != slow) {//然后以同样的速度移动
            fast = fast->next;
            slow = slow->next;
        }
        return fast;
    }

    /*解法二
    用快慢指针先找到环中节点的个数n，然后两个指针从头开始移动，P1先走n步之后P2再走，下次相遇的地方就是环的入口
    */
    ListNode *EntryNodeOfLoop2(ListNode *head) {
        if (head == NULL || head->next == NULL)
            return NULL;
        ListNode *slow = head;
        ListNode *fast = head;
        bool hasCycle = false;
        while (fast->next && fast->next->next) {
            slow = slow->next;
            fast = fast->next->next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        if (hasCycle == false)
            return NULL;

        //计算环中节点的个数
        int cycleNode = 1;
        while (fast->next != slow) {
            cycleNode ++;
            fast = fast->next;
        }

        //从头开始移动
        slow = head;
        fast = head;
        for (int i = 0; i < cycleNode; i ++) //fast 先走n步
            fast = fast->next;

        while (fast != slow) {
            fast = fast->next;
            slow = slow->next;
        }    
        
        return slow;
    }
    
};