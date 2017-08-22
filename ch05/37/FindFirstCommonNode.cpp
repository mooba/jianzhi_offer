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
    unsigned int getListLength(ListNode* pHead){
        int len;
        ListNode* tmp = pHead;
        if(tmp == NULL)
            len = 0;
        while(tmp != NULL){
            len ++;
            tmp =  tmp->next;
        }
        
        return len;
    }
    
    ListNode* FindFirstCommonNode( ListNode* pHead1, ListNode* pHead2) {
        if(pHead1 == NULL || pHead2 == NULL)
            return NULL;
        if(pHead1 == pHead2)
            return pHead1;
       
        int len1 = getListLength(pHead1);
        int len2 = getListLength(pHead2);
        
        int diffLen;
        ListNode* longer, *shorter;
        if(len1 >= len2){
            diffLen = len1 - len2;
            longer = pHead1;
            shorter = pHead2;
        }
        else{
            diffLen = len2 - len1;
            longer = pHead2;
            shorter = pHead1;
        }
        
        for(int i = 0; i < diffLen; i++){//长的先走lenDiff步
            longer = longer->next;
        }
        
        ListNode* result = NULL;
        while(longer!=NULL && shorter!=NULL){
        	if(longer == shorter){
                result = longer;
                break;
            }
            else{
                longer = longer->next;
                shorter = shorter->next;
            }
        }
        
        return result;
        
    }
};