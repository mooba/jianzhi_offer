/*输入一个链表，反转链表后，输出链表的所有元素。           */
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
    ListNode* ReverseList(ListNode* pHead) {
        ListNode* pPre = NULL;
        ListNode* pNode = pHead;
        ListNode* pReHead = NULL;//翻转之后的头指针
        
        while(pNode != NULL){
            ListNode* pNext = pNode->next;
            if(pNext == NULL)
                pReHead = pNode;
            
            pNode->next = pPre;
            pPre = pNode;
            pNode = pNext;
            
            
        }
        return pReHead;
    }
};