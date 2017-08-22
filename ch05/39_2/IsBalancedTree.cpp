class Solution {
public:
    bool IsBalanced_Solution(TreeNode* pRoot) {
        int depth;
        return isBalanced(pRoot, depth);

    }
    
    bool isBalanced(TreeNode *root, int &depth) {
        if (!root) {
            depth = 0;
            return true;
        }
        
        int left = 0, right = 0;
        if (isBalanced(root->left, left) && isBalanced(root->right, right)) {
            int diff = left - right;
            if (diff <= 1 && diff>= -1) {
                depth = 1 + (left > right ? left : right);
                return true;
            }
                
        }
        
        return false;
    }
};