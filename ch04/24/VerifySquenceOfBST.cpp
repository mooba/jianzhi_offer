// 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果
class Solution {
public:
    //第二遍刷题
    bool VerifySquenceOfBST(vector<int> sequence) {
        int len = sequence.size();
        if (0 == len)
            return false;

        int root = sequence[len - 1];
        int i = 0;

        //左子树的节点小于根节点
        for (; i < len - 1; i++) {
            if (sequence[i] > root)
                break;
        }

        //右子树的节点大于根节点
         for (int j = i; j < len - 1; j ++) {
             if (sequence[j] < root)
                 return false;
         }

         for(auto c: sequence) {
            cout<<c<<endl;
         }
        //判断左子树
        bool left = true;
        if (i > 0) {
            vector<int> leftTree(sequence.begin(), sequence.begin() + i);
            cout<<"leftTree:"<<endl;
            for (auto c: leftTree)
                cout<<c<<endl;
            left = VerifySquenceOfBST(leftTree);
        }


        //递归判读右子树
        bool right = true;
        if (i < len - 1) {
            vector<int> rightTree(sequence.begin() + i, sequence.begin() + len - 1);
            right = VerifySquenceOfBST(rightTree);
        }

        return right && left;
    }
};
