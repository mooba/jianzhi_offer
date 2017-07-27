/**
*  struct ListNode {
*        int val;
*        struct ListNode *next;
*        ListNode(int x) :
*              val(x), next(NULL) {
*        }
*  };
*/
class Solution {
public:
    //面试的时候遇到这个题可以跟面试官交流，可不可以改变链表的结构，如果可以的话可以用改变链表指针指向的方式去做
    //还可以问可不可以使用辅助空间。这样的交流不但可以进一步弄清楚面试官的意思，还可以给面试官留下积极思考，主动交流的印象
    /**************
    *利用vector及其方法，每遍历到一个节点就插入vector的最前面，或者插入后面最后调用reverse
    vector<int> printListFromTailToHead(ListNode* head) {
        vector<int> re;
        if(head == NULL)
            return re;
        ListNode* tmp = head;
        while(tmp != NULL){
            re.insert(re.begin(), tmp->val); 
            tmp = tmp->next;
        }
        
        return re;
    }
    ***********************/
    /*****这种翻转顺序的题目，很容易就要想到可以用递归或者用栈来解决，其中栈需要辅助空间，下面用递归来实现******/
    void tailToHeadHelp(ListNode *head, vector<int> &re){
        if(head->next == NULL)
            re.push_back(head->val);
        else{
            tailToHeadHelp(head->next, re);
            re.push_back(head->val);
        }
        	
    }
    vector<int> printListFromTailToHead(ListNode* head) {
        vector<int> re;
        if(head == NULL)
            return re;
        tailToHeadHelp(head, re);
        return re;
        
    }
};