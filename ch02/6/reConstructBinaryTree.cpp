/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

class Solution {
public:
    TreeNode* reConstructBinaryTree(vector<int> pre,vector<int> vin) {
        int pre_len = pre.size();
    	int in_len = vin.size();
    	if(pre_len == 0 || in_len == 0 || pre_len != in_len)
    		return NULL;

   		TreeNode *head = new TreeNode(pre[0]);//创建根节点
    	int root_ind = 0;//记录root在中序中的下标
		for(int i = 0; i<pre_len; i++){
			if(vin[i] == pre[0]){
				root_ind = i;
				break;
			}
		}

		vector<int> in_left, in_right,pre_left, pre_right;
		for(int j = 0; j<root_ind; j++){
			in_left.push_back(vin[j]);
			pre_left.push_back(pre[j+1]);//第一个为根根节点，跳过
		}
		for(int j = root_ind+1; j<pre_len; j++){
			in_right.push_back(vin[j]);
			pre_right.push_back(pre[j]);
		}

		//递归
		head->right = reConstructBinaryTree(pre_right, in_right);
		head->left = reConstructBinaryTree(pre_left, in_left);

   		return head;
    }
};