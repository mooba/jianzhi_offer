/*
struct RandomListNode {
    int label;
    struct RandomListNode *next, *random;
    RandomListNode(int x) :
            label(x), next(NULL), random(NULL) {
    }
};
*/
class Solution {
public:
    //第二遍刷题
    RandomListNode* Clone(RandomListNode* pHead)
    {
        if (pHead == NULL)
            return NULL;
        
        //先把复制的新节点插入到原链表中
        RandomListNode* tmpNode = pHead;
        while (tmpNode != NULL) {
            RandomListNode *newNode = new RandomListNode(tmpNode->label);
            newNode->next = tmpNode->next;
            tmpNode->next = newNode;
            
            tmpNode = newNode->next;
        }
        
        //为新节点的random指针赋值
        tmpNode = pHead;
        while (tmpNode != NULL) {
            RandomListNode* newNode = tmpNode->next;
            if (tmpNode->random != NULL)
                newNode->random = tmpNode->random->next;

            tmpNode = newNode->next;
        }
        
        //把链表拆分成两个链表
        tmpNode = pHead;
        RandomListNode* newHead = pHead->next;
        RandomListNode* newNode = newHead;        
        tmpNode->next = newNode->next;
        tmpNode = tmpNode->next;
        while (tmpNode != NULL) {
            newNode->next = tmpNode->next;
            newNode = newNode->next;
            tmpNode->next = newNode->next;
            tmpNode = tmpNode->next;
        }
        
        return newHead;
    }
};