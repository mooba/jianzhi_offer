/*
struct TreeNode {
	int val;
	struct TreeNode *left;
	struct TreeNode *right;
	TreeNode(int x) :
			val(x), left(NULL), right(NULL) {
	}
};*/
class Solution {
public:
    
    //第二遍刷题
    vector<int> PrintFromTopToBottom(TreeNode* root) {  
        
        vector<int> reVec; //初始一个空向量用于返回
        queue<TreeNode*> tempQueue;//辅助队列
        
        if (root == NULL)
            return reVec;
        
        tempQueue.push(root);
        while (!tempQueue.empty()) {
            TreeNode * tmpNode = tempQueue.front();
            reVec.push_back(tmpNode->val);
            if (tmpNode->left) 
                tempQueue.push(tmpNode->left);
            if (tmpNode->right)
                tempQueue.push(tmpNode->right);
            
          	tempQueue.pop();
        }
        
        return reVec;
    }
};