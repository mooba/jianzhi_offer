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
    int TreeDepth(TreeNode* pRoot)
    {
        //TreeNode* tmpNode = NULL;
        if(pRoot == NULL)
            return 0;
        
        int leftDepth, rightDepth;
        leftDepth = TreeDepth(pRoot->left);
        rightDepth = TreeDepth(pRoot->right);
        
        return (leftDepth > rightDepth) ? (leftDepth+1) : (rightDepth+1);    
    }
};