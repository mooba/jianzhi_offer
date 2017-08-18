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
    vector<vector<int >> rev;//用于返回的二维向量
    
    vector<vector<int> > FindPath(TreeNode* root, int expectNumber) {
        if (root == NULL || expectNumber < root->val)
            return rev;
        
        vector<int> path;
        int currentSum = 0;
        FindPath(root, expectNumber, path, currentSum);
        
        return rev;
    }
    
    void FindPath(TreeNode* root, int expectNumber, vector<int> &path, int currentSum) {
        currentSum += root->val;
        path.push_back(root->val);
        
        //如果是叶节点并且和等于给定的值，就记下当前路径
        if (currentSum == expectNumber && root->left == NULL && root->right == NULL) {
            rev.push_back(path);    
        }
        
        if (root->left && currentSum < expectNumber)
            FindPath(root->left, expectNumber, path, currentSum);
        
        if (root->right && currentSum < expectNumber)
            FindPath(root->right, expectNumber, path, currentSum);
            
        //返回之前pop出当前节点
        path.pop_back();
    }
    
};