/*输入一个链表，输出该链表中倒数第k个结点。
如果可以用额外空间的话，也可用栈来实现*/
/*
struct ListNode {
	int val;
	struct ListNode *next;
	ListNode(int x) :
			val(x), next(NULL) {
	}
};*/
class Solution {
public:
    ListNode* FindKthToTail(ListNode* pListHead, unsigned int k) {
        if(pListHead == NULL || k == 0) return NULL;
        
        ListNode* pAhead = pListHead;
        ListNode* pBehind = pListHead;
        
        
        for(unsigned int i = 0; i < k-1; ++i){
            if (pAhead->next != NULL)
                pAhead = pAhead->next;
            else
                return NULL;
        }
        
        while(pAhead->next != NULL){
            pAhead = pAhead->next;
            pBehind = pBehind->next;
        }
        return pBehind;
    }
};