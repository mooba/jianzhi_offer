// 操作给定的二叉树，将其变换为源二叉树的镜像
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
    void Mirror(TreeNode *pRoot) {
        if (pRoot == NULL)
            return;
        TreeNode *tmpNode = pRoot->left;
        pRoot->left = pRoot->right;
        pRoot->right = tmpNode;
        Mirror(pRoot->left);
        Mirror(pRoot->right);
    }
};